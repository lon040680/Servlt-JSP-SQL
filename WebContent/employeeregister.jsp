<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊</title>
</head>
<body>
	<div align="center">
		<h1>歡迎來到每日小日記</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
			<table style="with: 80%">
				<tr>
					<td>名字</td>
					<td><input type="text" name="fristName" /></td>
				</tr>
				<tr>
					<td>姓氏</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>使用者名稱</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>確認密碼</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>國家</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>手機</td>
					<td><input type="text" name="contact" /></td>
				</tr>
			</table>
			<input type="submit" value="註冊" />
		</form>
	</div>
</body>
</html>