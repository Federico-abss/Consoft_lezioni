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
			if (confirm("Vuoi veramente cancellare questo dipendente?")){
				document.location = "/prova/elimina_impiegato.do?id=" + id;
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
			<h1>${title}</h1>
			
			<p><button class="add_item" onclick="document.location='nuovo_impiegato.do';"><i class="fas fa-plus-circle"></i> aggiungi dipendente</button></p>
			
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Cognome</th>
						<th>Nome</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lista_employee}" var="employee" >
						<tr>
							<td>${employee.id}</td>
							<td>${employee.nome}</td>
							<td>${employee.cognome}</td>
							<td class="actions">
								<a href="dettaglio_impiegato.do?id=${employee.id}"><i class="fas fa-eye"></i></a>
								<a href="modifica_impiegato.do?id=${employee.id}"><i class="fas fa-edit"></i></a>
								<a class="delete_link" href="/elimina_impiegato.do" data-del-id="${employee.id}"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
	</body>
</html>