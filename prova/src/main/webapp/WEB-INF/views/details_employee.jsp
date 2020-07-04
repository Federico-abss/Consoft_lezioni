<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp" %>	
<title>Dettagli Impiegato</title>
</head>
<body>
	<div id="contenitore">
			<header>
			<%@ include file="menu.jsp" %>
		    </header>
			<h1>${title}</h1>
			
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Cognome</th>
						<th>Nome</th>
						<th>Progetti</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td>${employee.id}</td>
							<td>${employee.nome}</td>
							<td>${employee.cognome}</td>
							<td>
								<c:forEach items="${employee.projects}" var="project" >
								<p>${project.titolo}</p> 
								</c:forEach>
							</td>
						</tr>
				</tbody>
			</table>		
		</div>
</body>
</html>