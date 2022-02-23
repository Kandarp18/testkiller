<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
     <h2>Login</h2>
     <form method="post" action="login">
		Email: <input type="text" name="email"><br> <br>
		Password: <input type="password" name="password"><br> <br>
		<input type="submit" value="Login">
	</form>
	${error}${msg }
<br>
<a href="newuser">New User?</a> | 
<a href="forgotpassword">Forgot Password?</a>
</body>
</html>