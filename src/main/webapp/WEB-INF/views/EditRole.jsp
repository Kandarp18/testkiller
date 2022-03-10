<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
</head>
<body>
<h2>Edit Role</h2>

<form action="updaterole" method="post" >
		<input type="hidden" value="${role.roleId}" name="roleId"/>
		
		RoleName : <input type="text" name="roleName" value="${role.roleName }"/><br><br>
		<input type="submit" value="Update Role"/>
	</form>


</body>
</html>