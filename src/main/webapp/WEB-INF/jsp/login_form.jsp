<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post">
		<fieldset>
			<legend>登入頁面 - Login</legend>
			<input type="text" placeholder="請輸入使用者名稱" name="username" />
			<p />
			<input type="password" placeholder="請輸入使用者密碼" name="password" />
			<p />
			<button type="submit" class="pure-button pure-button-primary">
				登入
			</button>
			<button type="reset" class="pure-button pure-button-primary">
				清除
			</button>
			<p />
		</fieldset>
	</form>
</body>
</html>