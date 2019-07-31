<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hg.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("name")%>
	<table>
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
	</table>
</body>
</html>