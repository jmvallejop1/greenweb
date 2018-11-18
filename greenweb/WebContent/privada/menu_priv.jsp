<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

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
<%
	session = request.getSession(false);
	String id ="";
	if(session != null){
		session.setAttribute("id","vaBien");
		 id = (String)session.getAttribute("id");
	}
%>
	<header>
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
					<li><a href="preguntas_alu.jsp" target="body">Preguntas Recicladas</a></li>
					<li><a href="comentarios.jsp" target="body">Foro</a></li>
					<li id="cerrarSesion"><a href="../index.jsp" target="body">Cerrar Sesion</li>
					<li class="ALaDerecha"><a href="profile.jsp" target="body"><%out.println(id); %></a></li>
				</ul>			
			</div>
		</nav>
	</header>

</body>
</html>