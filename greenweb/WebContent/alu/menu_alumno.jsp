<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="../css/menus.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		 $("#cerrarSesion").click(function(){
		        $.post("../CerrarSesion", {
				}, function(data) {
				});
		    });
	});
	
</script>
<body>
	<header>
	<c:set var = "id" scope = "session" value = "pepe"/>
		<div id="main-header">
      		<h1>GREENWEB</h1>
    	</div>
		<nav class="navegacion">
			<div class="container">
				<ul class="menu">
					<li><a href="index_alu.jsp" target="body">Home</a></li>
					<li><a href="../noticias.jsp" target="body">Noticias</a></li>
					<li><a href="enlaces_alu.jsp" target="body">Enlaces</a><li>
					<li><a href="../ranking.jsp" target="body">Ranking</a></li>
					<li><a href="../preguntas.jsp" target="body">Preguntas Recicladas</a></li>
					<li><a href="trabajos.jsp" target="body">Trabajos</a></li>
					<li><a href="comentarios.jsp" target="body">Foro</a></li>
					<li id="cerrarSesion"><a href="../index.jsp" target="body">Cerrar Sesion</a></li>
					<li class="ALaDerecha"><a href="profile.jsp" target="body"><c:out value="${sessionScope.id}"></c:out></a></li>
				</ul>			
			</div>
		</nav>
	</header>

</body>
</html>