<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="head.jsp" %>		
		<title>Dipendenti</title>
		<script>	
				
		</script>
		
	</head>
	<body>
		<div id="contenitore">
			<header>
			<%@ include file="menu.jsp" %>
		    </header>
			<h1>Modifica impiegato</h1>
			
			<h2>Dettagli Impiegato</h2>
			<h3>Nome: ${employee.nome} <br> Cognome: ${employee.cognome}</h3>
			
			<form method="post" action="/prova/modifica_impiegato.do">
				<label for="fname">New First name:</label><br>
				<input type="text" id="fname" name="fname"><br>
				<label for="lname">New Last name:</label><br>
				<input type="text" id="lname" name="lname"><br><br>
				<input type="hidden" id="id" name="id" value="${employee.id}">
				<input type="submit" value="Submit">
			</form>			
			
		</div>
		
	</body>
</html>