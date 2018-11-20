<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
import="com.greenweb.cartel.*,java.util.List,com.greenweb.cartel.data.*"
import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*"
import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"
%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Trabajos</title>
	 <link rel="stylesheet" href="../css/trabajos.css">
	 <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
	 <link href="https://fonts.googleapis.com/css?family=Niramit:400,700" rel="stylesheet"> 
</head>
<body>
	<!-- BARRA DE NAVEGACION Y HEADER-->
   <iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	
	<h1> ¡Tablón con todos los carteles!</h1>
	<%
		CartelesManager cman=new CartelesManager();
		List<CartelDO> lista=cman.obtenerCartelesActuales();
	%>
	<input type="button" class="BotTrab" name="Cancelar" value="Añadir cartel" onclick="window.location.href='subir_archivos.jsp'"/>
	   <%
	   	for(CartelDO c: lista){
	   		%>
	   		<div class="Trabajo">
	   			<img src="../images/<%out.print(c.getFoto());%>" alt="Paris" onclick="window.open('reto.html')">
	   			<p>		
	   				<%out.println(c.getNoti().getTitulo());%>
	   			</p>
	   			<button type="submit" class="LikeAlu"/>Fav</button>  
	   		</div>	
	   		<%
	   	}
	   %>
   
 <iframe src="footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>
</body>
</html>