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

	<div class="easyui-layout" style="height: 350px">
		<div data-options="region:'north',split:true,collapsible:false" style="height: 50px">
			<%=request.getAttribute("name")%>
		</div>
		<div data-options="region:'west',split:true,collapsible:false"
			title="West" style="width: 300px;"></div>
		<div data-options="region:'center'" title="main"
			style="border-left: 0px; border-right: 0px;">
			<table class="easyui-datagrid" title="Basic DataGrid"
				style="border-left: 0px; border-right: 0px;">
				<thead>
					<tr>
						<th field="name1">1</th>
						<th field="name2">2</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<User> userList = (List<User>) request.getAttribute("users");
						for (int i = 0; i < userList.size(); i++) {
							User user = userList.get(i);
					%>
					<tr>
						<td><%=user.getAccountID()%></td>
						<td><%=user.getName()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>