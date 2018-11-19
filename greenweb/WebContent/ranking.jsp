<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ranking</title>
<link rel="stylesheet" href="css/ranking.css">
<script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
</head>

<body>
	<%@include file="menu.jsp"%>
	<c:set var = "hasta" scope = "session" value = "9"/>
	<jsp:useBean id="man" class="com.greenweb.usuario.UsuarioManager"/>
	<table class="container">
		<thead>
			<tr>
				<th>Posicion</th>
				<th>Usuario</th>
				<th>Puntuacion</th>
			</tr>
		</thead>
		<c:if test = "${sessionScope.hasta > fn:length(man.ranking)}">
			<c:set var = "hasta" scope = "session" value = "${fn:length(man.ranking)}"/>
		</c:if>						
		<c:forEach var="usuario" end="${sessionScope.hasta}" items="${man.ranking}" varStatus="loop">
			<tr>
				<td><c:out value="${loop.count}"></c:out></td>
				<td><c:out value="${usuario.username}"></c:out></td>
				<td><c:out value="${usuario.puntos}"></c:out></td>
			</tr>
		</c:forEach>					
	</table>	
</body>

<iframe src="footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>

</html>