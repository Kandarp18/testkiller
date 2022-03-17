<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
</head>
<body>
	<h2>List Users</h2>


	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
		    <th>Password</th>
		    <th>Gender</th>
		    <th>Contact No</th>
			<th>RoleName</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td>${u.email}</td>
				<td>${u.password}</td>
				<td>${u.gender }</td>
				<td>${u.contactNo }</td>
				<td>${u.roleName}</td>
				<td><a href="deleteuser/${u.userId}">Delete</a></td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>