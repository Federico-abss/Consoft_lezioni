<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Progetti</title>
</head>
<body>

	<ul>
		<c:forEach items="${lista_project}" var="project">
			<li> ${project.titolo} </li>
		</c:forEach>
	
	</ul>

</body>
</html>