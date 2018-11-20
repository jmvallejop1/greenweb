<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title> Mi cuenta </title>
	<link rel="stylesheet" href="../css/styleProfile.css">
	<script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		 var ti = $("#tipo").html();
		 tipo(ti);
	});
	</script>
	<script>
	function tipo(t){
		if(t == "u"){
			$("#tipo").html("USUARIO");
		}else if(t == "a"){
			$("#tipo").html("ALUMNO");
		}else if(t == "p"){
			$("#tipo").html("PROFESOR");
		}
	}
	</script>
	<script>
	function estudio(t){
		if(t == 1){
			$("#tipo").html("USUARIO");
		}else if(t == 2){
			$("#tipo").html("ALUMNO");
		}else if(t == 3){
			$("#tipo").html("PROFESOR");
		}
	}
	</script>
	
	<script>
	function baja(){
		if(confirm("Quiere darse de baja?")){
			$.post('../Baja', {
			}, function(responseText) {
			});
		}else{
			alert("No se ha dado de baja");
		}
		
	}
	</script>
	
</head>
<body>
	<c:set var="id" value="pepe" scope="session" />
	<jsp:useBean id="man" class="com.greenweb.usuario.data.UsuarioDO"/>
	<jsp:setProperty name="man" property="loadUsername" value="${sessionScope.id}" />   	               
	<iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<div class="box2">
		<img src="../images/perfil.jpg" alt="Su foto de perfil" id="ProfPic">
		<div class="infoUser">
			<center>
				<h2> InformaciÃ³n personal de <c:out value="${man.nombre}"></c:out></h2>
				<table>
					<tr class="data"><td>Tipo de cuenta: </td><td id="tipo"><c:out value="${man.tipo}"></c:out></td></tr>
					<tr class="data"><td>Id de usuario: </td><td><c:out value="${man.username}"></c:out></td></tr>
					<tr class="data"><td>Correo electrÃ³nico: </td><td> <c:out value="${man.mail}"></c:out></td></tr>
					<tr class="data"><td>Edad: </td><td><c:out value="${man.edad}"></c:out></td></tr>
					<tr class="data"><td>Ocupacion actual: </td><td><c:out value="${man.estudios}"></c:out></td></tr>
					<tr><td><a href="editProfile.jsp">Editar datos</a></td></tr>
					<tr><td onclick="baja()">Dar usuario de baja</a></td></tr>
				</table>
			</center>
		</div>     
	</div>
	<div class="botones">
		<input type="button" name="gestAlu" value="Gestionar alumnos" onClick="window.location.href='gesAlu.jsp'"> 
		<input type="button" name="gestPro" value="Gestionar profesores" onClick="window.location.href='gesPro.jsp'">
	</div>
	<div class="container">
		<table>
			<caption align="top">Estado de la entrega</caption>
				<tr>
					<td>Trabajo</td>
					<td> Ningun trabajo </td>
				</tr>
				<tr class="alt">
					<td> Estado de entrega</td>
					<td> Sin entregar </td>
				</tr>
				<tr>
					<td> Fecha de entrega </td>
					<td> No figura </td>
					</tr>
				<tr class="alt">
					<td> Ultima modificacion </td>
					<td> Sin modificar </td>
				</tr>
		</table>
	</div>
	<iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>
</body>
</html>
            
