<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.enlace.*,java.util.List,com.greenweb.enlace.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">
 <head>
	<title> Enlaces </title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../css/enlaceStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet"> 
	<script>
		$(document).ready(function() {
			$('#submit').click(function(event) {
				$.post('../mas5/mas5.jsp', {
					num: 1
				}, function(responseText) {
					$('#tabla').html(responseText);
				});
			});
		});
	</script>
 </head>  
<body>
	<iframe src="menu_priv.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>   
	<div class="info">
		<p align="center"><strong>¡Bienvenidos a nuestra sección de enlaces hacia fuentes de información fiables!</strong></p>
	<p align="center">En esta seción encontrareis una colección de enlaces a medios de información que proporcionan información fiable y verídica. Además cuanto más arriba esté el enlace, querrá decir que más alumnos y profesores del departamento de ingeniería quÃ­mica y del medio ambiente de la universidad de Zaragoza lo han seleccionado como fiable. ¡Infórmate de una manera responsable aquí!</p>
	</div>
	<jsp:useBean id="man" class="com.greenweb.enlace.EnlacesManager"/>
	<c:if test = "${sessionScope.hasta > fn:length(man.enlaces)}">
		<c:set var = "hasta" scope = "session" value = "${fn:length(man.enlaces)}"/>
	</c:if>
	<div class="container">
		<table id="tabla">
			<thead>
				<tr><th>Enlaces mejor valorados</th><th>Votos verdes</th></tr>
			</thead>	
			<c:forEach var="enlace" end="5" items="${man.enlaces}">
				<tr><td><c:out value="${enlace.URL}"></c:out></td> <td class="prueba"><c:out value="${enlace.votos}"></c:out></td></tr>			
			</c:forEach>
		</table>
		<input type="button" id="submit" value="Mostrar Enlaces" /> 
	</div>
	<iframe src="../footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>
</body>
</html>
