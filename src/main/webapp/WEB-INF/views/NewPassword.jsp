<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Password</title>
</head>
<body>
<h2>Update Password</h2>
<form method="post" action="updatepassword">
		Email : <input type="text" name="email"/><br> <br> 
		Otp : <input type="text" name="otp" /><br> <br> 
		Password : <input type="password" name="password" /><br><br> 
		Confirm Password : <input type="password" name="confirmPassword" /><br><br> 
		<input type="submit" value="Update Password"/> 
	</form>
	${msg}${error}

</body>
</html>