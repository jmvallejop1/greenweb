<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="es">
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
	$(document).ready(function() {
		 var ti = $("#est").html();
		 estudio(ti);
	});
	</script>
	<script>
	function estudio(t){
		if(t == 1){
			$("#est").html("Ingeniero");
		}else if(t == 2){
			$("#est").html("EstudianteMedicina");
		}else if(t == 3){
			$("#est").html("Empresario");
		}else if(t == 4){
			$("#est").html("EstudianteTic");
		}else if(t == 5){
			$("#est").html("Estudiante Ciencias Sociales");
		}else if(t == 6){
			$("#est").html("Estudiante Ciencias Salud");
		}else if(t == 7){
			$("#est").html("Estudiante letras");
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
	<jsp:useBean id="man" class="com.greenweb.usuario.data.UsuarioDO"/>
	<jsp:setProperty name="man" property="loadUsername" value="${sessionScope.id}" />   	               
	<iframe src="menu_priv.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<div class="box2">
		<img src="../images/negro.jpg" alt="Su foto de perfil" id="ProfPic">
		<div class="infoUser">
			<center>
				<h2> Información personal de <c:out value="${man.nombre}"></c:out></h2>
				<table>
					<tr class="data"><td>Tipo de cuenta: </td><td id="tipo"><c:out value="${man.tipo}"></c:out></td></tr>
					<tr class="data"><td>Id de usuario: </td><td><c:out value="${man.username}"></c:out></td></tr>
					<tr class="data"><td>Correo electrónico: </td><td> <c:out value="${man.mail}"></c:out></td></tr>
					<tr class="data"><td>Edad: </td><td><c:out value="${man.edad}"></c:out></td></tr>
					<tr class="data"><td>Ocupacion actual: </td><td id="est"><c:out value="${man.estudios}"></c:out></td></tr>
					<tr><td><a href="editProfile.jsp">Editar datos</a></td></tr>
					<tr><td onclick="baja()">Dar usuario de baja</a></td></tr>
				</table>
			</center>
		</div>     
	</div>

	<iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>
</body>
</html>
            
