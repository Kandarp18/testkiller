<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>list roles</h2>
<a href="newrole">New Role</a>
<table border="1">
<tr>
	<th>Role Id</th>
	<th>Role Name</th>
	<th>Action</th>
</tr>

<c:forEach items="${roles}" var="role">
	<tr>
		<td>${role.roleId}</td>
		<td>${role.roleName}</td>
		<td><a href="deleterole/${role.roleId}">Delete</a> | 
			<a href="editrole?roleId=${role.roleId}">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>