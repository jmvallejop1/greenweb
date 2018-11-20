<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.enlace.*,java.util.List,com.greenweb.enlace.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="es">
 <head>
	<title> Enlaces </title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../css/enlaceStyle.css">
	<link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet"> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#submitalu').click(function(event) {
				$.post('../mas5/mas5alu.jsp', {}, function(data,status) {
					$('#sus').html(data);
				});
			});
		});
	</script>
	<script>
		var vot;
		$(document).ready(function() {
			$(".vota").click(function(){
				var miVar =  $(this).prev().prev().text();
				vot = $(this).prev();
		        	$.post("../SumaVoto", {
						id: miVar
					}, function(data) {	
						$(vot).text(data);
				});
		   	});
		});	
	</script>
	<script>
		$(document).ready(function() {
			$("#subir").click(function(){
				var miVar = $("#InputEnlace").val();
		        alert("Text: " + $("#InputEnlace").val());
		        $.post("../SubirEnlace", {
					id: miVar
				}, function() {
				});
		    });
		});	
	</script>
	
</head> 
<body>
	<iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<div class="contenedor">
	<div class="info">
		<p align="center"><strong>¡Bienvenidos a nuestra sección de enlaces hacia fuentes de información fiables!</strong></p>
		<p align="center">En esta seción encontrareis una colección de enlaces a medios de información que proporcionan información fiable y verídica. Además cuanto más arriba esté el enlace, querrá decir que más alumnos y profesores del departamento de ingeniería quÃ­mica y del medio ambiente de la universidad de Zaragoza lo han seleccionado como fiable. ¡Infórmate de una manera responsable aquí!</p>
	</div>
	<jsp:useBean id="man" class="com.greenweb.enlace.EnlacesManager"/>
	<c:if test = "${sessionScope.hasta > fn:length(man.enlaces)}">
		<c:set var = "hasta" scope = "session" value = "${fn:length(man.enlaces)}"/>
	</c:if>
	<div class="container">
		<center>
			<input type="url" id="InputEnlace" placeholder="        Añade tu enlace"></td></tr>
			<input type="button" name="subirLink" id="subir" value="Subir enlace">
			<div id="sus">
				<table class="tabla">
					<thead>
						<tr><th>Enlaces mejor valorados</th><th>Votos verdes</th><th>Vota</th></tr>
					</thead>		
					<c:forEach var="enlace" end="5" items="${man.enlaces}">
						<tr><td><c:out value="${enlace.URL}"></c:out></td><td class="prueba"><c:out value="${enlace.votos}"></c:out></td><td class="vota"><img src="../images/fiable.png"></td></tr>	
					</c:forEach>	
				</table>
			</div>
			<input type="button" id="submitalu" value="Mostrar Enlaces" /> 
		</center>
	</div>
	</div>
	<iframe src="../footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>
</body>
</html>

