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
			<h1>Inserisci un nuovo impiegato</h1>
			
			<form method="post" action="/prova/nuovo_impiegato.do">
				<label for="fname">First name:</label><br>
				<input type="text" id="fname" name="fname"><br>
				<label for="lname">Last name:</label><br>
				<input type="text" id="lname" name="lname"><br><br>
				<input type="submit" value="Submit">
			</form>			
			
		</div>
		
	</body>
</html>