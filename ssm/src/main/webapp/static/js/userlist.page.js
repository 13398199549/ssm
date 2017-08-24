$(function(){
	/**
	 * 查询方法
	 */
	 $('#search').bind('click', function(){   
	       var userName = $('#userName').val();
	       var loginName = $('#loginName').val();
	       var age = $('#age').val();
	       var gender = $('#gender').combobox('getValue');
	       var datas = {userName:userName,loginName:loginName,age:age,gender:gender};
	       $('#tt').datagrid('load',datas);
	    }); 
	
	 $('#add').bind('click', function(){   
		 $('#dlg').dialog('open'); 
		 
		 
		 
		 //$('#dlg').dialog('close')
	    }); 
	 $('#edit').bind('click', function(){   
		 var row = $('#tt').datagrid('getSelected');
		 var rows = $('#tt').datagrid('getSelections');
		 if(row){
			 var lenth = rows.length;
			 if(lenth == 1){
				 $('#dlg').dialog('open'); 
				 var id = row.id;
				 var userName = row.userName;
				 
				 
				 
			 }else{
				 $.messager.show({
						title:'提示信息',
						msg:'每次只能修改一条数据！',
						timeout:5000,
						showType:'slide'
					});
			 }
			 
		 }else{
			 $.messager.show({
					title:'提示信息',
					msg:'请选择需要修改的列表项！',
					timeout:5000,
					showType:'slide'
				});
		 }
	    }); 
	 /**
	  * 删除方法
	  */
	 $('#remove').bind('click', function(){   
	        
		 var rows = $('#tt').datagrid('getSelections');
		 var lenth = rows.length;
		 if(lenth == 0){
			 $.messager.show({
					title:'提示信息',
					msg:'请选择需要删除的列表项！',
					timeout:5000,
					showType:'slide'
				});
		 }else{
			 $.messager.confirm('确认窗体', '你确认需要删除以下数据么?', function(r){
					if (r){
						var ids = [];
						for(var i = 0; i < lenth; i ++){
							ids.push(rows[i].id);
						}
						
						var json = $.toJSON(ids);//将JS对象转换为JSON对象
						$.ajax({
							type:"DELETE",
							url:"users/"+ids,
							data:json,
							async:true,
							contentType:"application/json",
							success:function(data){
								//不需要再写json.parse(data);
								 $.messager.show({
										title:'提示信息',
										msg:data.info,
										timeout:5000,
										showType:'slide'
									});
								 $('#tt').datagrid('reload');//刷新数据列表
							}
						});
					}
				});
		 	}
	    }); 
	
	 /**       
	 * 对Date的扩展，将 Date 转化为指定格式的String       
	 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
	 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)       
	 * eg:       
	 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
	 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
	 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
	 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
	 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
	 */          
	Date.prototype.pattern=function(fmt) {           
	    var o = {           
	    "M+" : this.getMonth()+1, //月份           
	    "d+" : this.getDate(), //日           
	    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
	    "H+" : this.getHours(), //小时           
	    "m+" : this.getMinutes(), //分           
	    "s+" : this.getSeconds(), //秒           
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
	    "S" : this.getMilliseconds() //毫秒           
	    };           
	    var week = {           
	    "0" : "/u65e5",           
	    "1" : "/u4e00",           
	    "2" : "/u4e8c",           
	    "3" : "/u4e09",           
	    "4" : "/u56db",           
	    "5" : "/u4e94",           
	    "6" : "/u516d"          
	    };           
	    if(/(y+)/.test(fmt)){           
	        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
	    }           
	    if(/(E+)/.test(fmt)){           
	        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
	    }           
	    for(var k in o){           
	        if(new RegExp("("+ k +")").test(fmt)){           
	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
	        }           
	    }           
	    return fmt;           
	}  
	
	/*
	
	$('#btn04').click(function(){

		var id = "4";
		$.ajax({
			type:"GET",
			url:"users/"+id,
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	
	$('#btn03').click(function(){

		var id = "3";
		$.ajax({
			type:"DELETE",
			url:"users/"+id,
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	
	$('#btn02').click(function(){
		var user = {userName:"小黄峰",loginName:"p",
				password:"123456",age:"19"};
		var id = "4";
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		$.ajax({
			type:"PUT",
			url:"users/"+id,
			data:json,
			async:true,
			contentType:"application/json",
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	
	//新增
	$('#btn01').click(function(){
		var user = {userName:"大黄峰",loginName:"p",
				password:"123456",age:"19"};
		
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		$.ajax({
			type:"POST",
			url:"users/-1",
			data:json,
			async:true,
			contentType:"application/json",
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	*/
});