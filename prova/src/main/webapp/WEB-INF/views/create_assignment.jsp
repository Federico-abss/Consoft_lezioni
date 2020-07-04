<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="head.jsp" %>		
		<title>Nuova Assegnazione</title>
		<script>	
				
		</script>
		
	</head>
	<body>
		<div id="contenitore">
			<header>
			<%@ include file="menu.jsp" %>
		    </header>
			<h1>Inserisci una nuova assegnazione</h1>
			
			<form method="post" action="/prova/nuova_assegnazione.do">
				<label for="employee">Dipendente:</label><br>
				<select id="employee" name="id_employee">
					<c:forEach items="${impiegati}" var="impiegato" >
			        	<option value="${impiegato.id}">${impiegato.cognome} ${impiegato.nome}</option>
			        </c:forEach>
			    </select><br>
				<label for="project">Progetto:</label><br>
				<select id="project" name="id_project">
					<c:forEach items="${progetti}" var="progetto" >
			        	<option value="${progetto.id}">${progetto.titolo}</option>
			        </c:forEach>
			    </select><br><br>
				<input type="submit" value="Submit">
			</form>			
			
		</div>
		
	</body>
</html>