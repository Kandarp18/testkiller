<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${q }" var="q">
${q.answer}

</c:forEach>
<br><br>
<c:forEach items="${u }" var="u">
${u.userAns}
<table id="listProject">
dvbfngmh, 
</table>
</c:forEach>
</body>
</html>