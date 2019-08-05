<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hg.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/easyUIDemo/jquery.min.js"></script>
<script type="text/javascript" src="js/easyUIDemo/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/themes/icon.css"></link>
<link rel="stylesheet" type="text/css"
	href="js/easyUIDemo/demo/demo.css"></link>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	width: 100%;
	height: 100%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%
		List<User> userList = (List<User>) request.getAttribute("users");
	%>
	<div class="easyui-layout" style="height: 350px">

		<div data-options="region:'north',split:true,collapsible:false"
			style="height: 50px">
			<%=request.getAttribute("name")%>
		</div>

		<div data-options="region:'west',split:true,collapsible:false"
			title="West" style="width: 300px;">
			<div class="easyui-sidemenu"
				data-options="data:datalist,onSelect:function(obj){		
				if(obj.text=='用户管理'){
					post('user');
				}else if(obj.text=='设备管理'){
					post('user');		
				}
				
			}"
				style="width: 293px;"></div>
		</div>

		<div data-options="region:'center'" title="main"
			style="border-left: 0px; border-right: 0px;">
			<%=request.getAttribute("test")%>
		</div>
	</div>

	<script type="text/javascript">
		var datalist = [ {
			text : '用户管理',
			children : [ {
				text : '用户管理'
			} ]
		}, {
			text : '设备管理',
			children : [ {
				text : '设备管理'
			} ]
		} ]

		function post(o) {
			var f = document.createElement("form");
			f.action = o;
			f.method = "post";
			var hdnFilePath = document.createElement('input');
			hdnFilePath.type = "hidden";
			hdnFilePath.name = "user";
			hdnFilePath.value = "1";
			f.appendChild(hdnFilePath);
			document.body.appendChild(f);
			f.submit();
		}
	</script>
</body>
</html>