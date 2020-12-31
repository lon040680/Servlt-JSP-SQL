<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>歡迎來到每日小日記</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="with: 100%">
				<tr>
					<td>使用者名稱</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="登入" />
		</form>
		<br>
		<form action="<%=request.getContextPath()%>/employeeregister.jsp" method="post">
			<input type="submit" value="還沒註冊嗎?" />
		</form>
	</div>
</body>
</html>