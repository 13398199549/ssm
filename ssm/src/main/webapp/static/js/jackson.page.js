$(function(){
	
	//适用于多表联查时，返回不同的字段
	$('#btn07').click(function(){

		var userName = "小";
		
		$.ajax({
			type:"POST",
			url:"jsons/seven",
			data:{userName:userName},
			async:true,
			success:function(data){
				console.info(data);
			}
		});
	});
	
	//分页条件查询
	$('#btn06').click(function(){
		var params = {userName:"小",age:"19",page:1,rows:8};
		$.ajax({
			type:"POST",
			url:"jsons/six",
			data:params,
			async:true,
			success:function(data){
				console.info(data);
			}
		});
	});
	
	//根据用户名查询大批量用户
	$('#btn05').click(function(){

		var userName = "小";
		
		$.ajax({
			type:"POST",
			url:"jsons/five",
			data:{userName:userName},
			async:true,
			success:function(data){
				var length = data.length;
				for(var i =0; i <length; i++){
					console.info(data[i]);
				}
			}
		});
	});
	
	//批量删除
	$('#btn04').click(function(){

		var id = "1";
		var id2 = "2";
		var id3 = "3";
		var ids = [];
		ids.push(id);
		ids.push(id2);
		ids.push(id3);
		
		var json = $.toJSON(ids);
		
		$.ajax({
			type:"POST",
			url:"jsons/four",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				alert(data.status);
				alert(data.info);
			}
		});
	});
	
	
	//单个传递字符串（可以传ID，就可以传userName,loginName,age）
	$('#btn03').click(function(){

		var id = "1";//单个传递字符串（推荐不要转换为JSON）
		$.ajax({
			type:"POST",
			url:"jsons/three",
			data:{id:id},
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				alert(data.status);
				alert(data.info);
			}
		});
	});
	
	//批量新增以及删除
	$('#btn02').click(function(){
		var user = {id:"1",userName:"大黄",loginName:"l",
				password:"123456",age:"19"};
		var user2 = {id:"2",userName:"小黄",loginName:"k",
				password:"123456",age:"12"};
		var users = [];
		users.push(user);
		users.push(user2);
		
		var json = $.toJSON(users);//将JS对象转换为JSON对象[{},{}]
		$.ajax({
			type:"POST",
			url:"jsons/two",
			data:json,
			async:true,
			contentType:"application/json",
			success:function(data){
				//不需要再写json.parse(data);
				alert(data.status);
				alert(data.info);
			}
		});
	});
	
	
	//单个新增或修改
	$('#btn01').click(function(){
		var user = {id:"1",userName:"大黄",loginName:"l",
				password:"123456",age:"19"};
		
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		$.ajax({
			type:"POST",
			url:"jsons/one",
			data:json,
			async:true,
			contentType:"application/json",
			success:function(data){
				//不需要再写json.parse(data);
				alert(data.status);
				alert(data.info);
			}
		});
	});
	
	
	
	
	
});