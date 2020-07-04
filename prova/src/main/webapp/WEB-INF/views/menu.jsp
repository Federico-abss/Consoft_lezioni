<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		        <nav id="main_menu">
		            <ul>
		                <li<c:if test="${requestScope['javax.servlet.forward.request_uri'] == \"/\" || requestScope['javax.servlet.forward.request_uri'] == \"/employees\" }"> class="current"</c:if>><a href="/prova/impiegati.do">dipendenti</a></li>
		                <li<c:if test="${requestScope['javax.servlet.forward.request_uri'] == \"/projects\" }"> class="current"</c:if>><a href="/prova/progetti.do">progetti</a></li>
		                <li<c:if test="${requestScope['javax.servlet.forward.request_uri'] == \"/assignments\" }"> class="current"</c:if>><a href="/prova/assegnazioni.do">assegnazioni</a></li>
		            </ul>
		        </nav>