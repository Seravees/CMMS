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
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("name")%>
	<div class="easyui-layout" style="width: 700px; height: 350px">
		<div data-options="region:'center',title:'main'">
			<table class="easyui-datagrid" title="Basic DataGrid"
				style="width: 600px; height: 250px">
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