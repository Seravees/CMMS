<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>

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

	<div class="easyui-panel" title="登录" style="width: 400px">
		<form action="login" method="post">
			<table cellpadding="5">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="accountID"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="psd"></td>
				</tr>
			</table>
			<input type="submit" value="登录">
		</form>
	</div>


</body>
</html>