<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.comentario.*,java.util.List,com.greenweb.comentario.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <html lang="en">
  <head>
	<meta charset="utf-8">
	<title> Pagina de comentarios </title>
	<link rel="stylesheet" href="../css/comentarios.css">
	<meta name="viewport" content="width=device-width, initial.scale=1">	
	<link rel="stylesheet" href="css/font-awesome.-mi">
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
   
<body>
	<iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<jsp:useBean id="man" class="com.greenweb.comentario.ComentarioManager"/>
	<form method="post">
		<div class="contenedor_comentarios">
			<h1> Foro de comentarios <a href="tal"></a></h1>
			<ul id="lista_comentarios" class="lista_comentarios">				
			<c:forEach var="comentario"  items="${man.comentarios}">	
				<li>
					<div class="comentario_principal">
						<div class="comentario_caja">
							<div class="comentario_cabeza">
								<h6 class="nombre_comentario by-author"><a href="perfil.html"><c:out value="${comentario.idUser}"></c:out></a></h6> 
							</div>
							<div class="comentario_contenido">
								<c:out value="${comentario.comentario}"></c:out>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>		
			</ul>
		</div>			
		<div class="pedir_comentario">
			<h3> Añade tu comentario y ayudanos a mejorar </h3>
			<textarea name="mejorar" id="mejorar"></textarea><br/>
			<input type="button" name="Confirmar" value="Envia tu comentario" onClick="window.location.href='comentarios.html'"> 
		</div>
	</form>
	<iframe src="../footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>
 </body>
</html>