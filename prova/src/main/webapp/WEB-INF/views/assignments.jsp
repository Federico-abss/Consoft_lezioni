<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="head.jsp" %>		
		<title>Dipendenti</title>
		<script>
		
		function deleteConfirm(id) {
			if (confirm("Vuoi veramente cancellare questa assegnazione?")){
				document.location = "/prova/elimina_assegnazione.do?" + id;
			}
		}
		
		$(function(){
			// tutto il codice di questa function viene eseguito solo dopo il caricamento completo della pagina	
			$('.delete_link').click(function(){
				
				//alert("hai cliccato sull'ancora di cancellazione");
				id = $(this).data('del-id');
				deleteConfirm(id);
				return false;
			});
			
		});
		
		function pippo() {
			
		}
		
		</script>
		
	</head>
	<body>
		<div id="contenitore">
			<header>
			<%@ include file="menu.jsp" %>
		    </header>
			<h1>Elenco Assegnazioni</h1>
			
			<p><button class="add_item" onclick="document.location='nuova_assegnazione.do';">
			<i class="fas fa-plus-circle"></i> aggiungi assegnazione</button></p>
			
			<table>
				<thead>
					<tr>
						<th>Cognome</th>
						<th>Nome</th>
						<th>Progetto</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lista_assegnazioni}" var="assegnazione" >
						<tr>
							<td>${assegnazione.cognome}</td>
							<td>${assegnazione.nome}</td>
							<td>${assegnazione.titolo}</td>
							<td class="actions">
								<a href="employee?id_employee=${assegnazione.id_employee}&
								id_project=${assegnazione.id_project}"><i class="fas fa-eye"></i></a>
								<a href="employee_edit?id_employee=${assegnazione.id_employee}&
								id_project=${assegnazione.id_project}"><i class="fas fa-edit"></i></a>
								<a class="delete_link" href="/elimina_impiegato.do" data-del-id="id_employee=${assegnazione.id_employee}&
								id_project=${assegnazione.id_project}"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
	</body>
</html>