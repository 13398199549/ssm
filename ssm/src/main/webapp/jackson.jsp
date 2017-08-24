<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=basePath %>static/js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jquery.json-2.4.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>static/js/jackson.page.js" charset="utf-8"></script>
</head>
<body>
	
	<button id="btn01">单个新增/修改/删除</button>
	<button id="btn02">批量新增/删除</button>
	<button id="btn03">单个删除</button>
	<button id="btn04">批量删除</button>
	<button id="btn05">根据用户名查询大批量用户</button>
	<button id="btn06">分页条件查询</button>

	<button id="btn07">根据用户名查询返回Map</button>


</body>
</html>