<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/css/themes/icon.css">
<script type="text/javascript" src="<%=basePath %>static/js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.json-2.4.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/userlist.page.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
</head>
<body class="easyui-layout">
	<!-- <button id="btn01">新增</button>
	<button id="btn02">修改</button>
	<button id="btn03">删除</button>
	<button id="btn04">查询</button> -->
	
	<div data-options="region:'north',title:'查询条件',split:true" style="height:100px;">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="easyui-validatebox" id="userName" />  
				</td>
				<td>登录名：</td>
				<td><input class="easyui-validatebox" id="loginName" />  </td>
				<td>年龄：</td>
				<td><input class="easyui-validatebox" id="age" /></td>
				<td>性别：</td>
				<td><input id="gender" class="easyui-combobox" 
    			data-options="valueField:'id',textField:'text',method:'GET',url:'users/gender'" /></td>
    			<td><a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>  </td>
			</tr>
		</table>
	</div>  
    <div data-options="region:'center',title:'数据列表'" style="padding:5px;background:#eee;">
    	<table class="easyui-datagrid" id="tt" style="width:auto;height:100%"  
        data-options="url:'users/page',method:'GET',fitColumns:true,singleSelect:false,pagination:true,toolbar: '#tb'
        ,onDblClickRow:function(rowIndex, rowData){
        	// 做详细展示
        	alert(rowData.userName);
        }">  
		    <thead>  
		        <tr>  
		        	<th data-options="field:'ck',checkbox:true"></th>
		            <th data-options="field:'userName',width:100,align:'center'">用户名称</th>  
		            <th data-options="field:'loginName',width:100,align:'center'">登录名称</th>  
		            <th data-options="field:'age',width:100,align:'center'">年龄</th> 
		            <th data-options="field:'createTime',width:100,align:'center',
		            formatter: function(value,row,index){
		            	var text = '';
		            	var date = new Date(value);
						text = date.pattern('yyyy-MM-dd hh:mm:ss');
						return text;
				}
		            ">创建时间</th>   
		        </tr>  
		    </thead>  
		</table>  
    </div>  
	
	<div id="tb">
		<a href="javascript:void(0)" id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
		<a href="javascript:void(0)" id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a href="javascript:void(0)" id="remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog" title="Toolbar and Buttons" style="width:400px;height:200px;padding:10px"
            data-options="
                iconCls: 'icon-save',
                closed:'true',
                buttons: [{
                    text:'Ok',
                    iconCls:'icon-ok',
                    handler:function(){
                        alert('ok');
                    }
                },{
                    text:'Cancel',
                    handler:function(){
                        $('#dlg').dialog('close')
                    }
                }]
            ">
    </div>
</body>
</html>