<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
<h2>Forgot Password</h2>
    <form method="post" action="forgotpassword">
		Email: <input type="text" name="email"><br> <br>
		<input type="submit" value="Submit">
	</form>
	${error}
</body>
</html>