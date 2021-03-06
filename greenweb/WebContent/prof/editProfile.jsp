<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Mi cuenta</title>
	<meta charset="utf-8">
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
   </head>
   <body>
	<jsp:useBean id="man" class="com.greenweb.usuario.data.UsuarioDO"/>
	<jsp:setProperty name="man" property="loadUsername" value="${sessionScope.id}" />   
      <iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
         <!--AquÃ­ irÃ­a el frame de la cabecera y el menu-->
      <div class="box2">
         <img src="../images/negro.jpg" alt="Su foto de perfil" id="ProfPic">
         <div class="infoUser">
            <center>
               <h2> Información personal de Nombre Apellido</h2>
               <!--Recoger la info del usuario y rellenar los campos con la respuesta-->
               <table>
                  <tr class="data"><td>Tipo de cuenta: </td><td id="tipo"><c:out value="${man.tipo}"></c:out></td></tr></tr>
                  <form action="../CambiarDatos" method="post">
                     <tr class="data"><td>Id de usuario: </td><td><c:out value="${man.username}"></c:out></td></tr>
                     <!-- AquÃ­ se debe comprobar que el nombre de usuario esta libre -->
                     <tr class="data"><td>Correo electrÃ³nico: </td><td><input name="email"type="email" placeholder="<c:out value="${man.mail}"></c:out>"></td></tr>
                     <tr class="data"><td>Edad: </td><td><input type="age" name="age" placeholder="<c:out value="${man.edad}"></c:out>"></td></tr>
                     <tr class="data"><td>Ocupacion actual: </td>
                        <td><select name="ocupacion"><option value ="0"> Selecciona ocupacion</option><option value ="1">Ingeniero</option><option value ="2">Medico</option><option value ="3">Empresario</option><option value ="4">Estudiante TIC</option><option value ="5">Estudiante Ciencias Sociales</option><option value ="6">Estudiante Ciencias Salud</option><option value ="7">Estudiante Letras</option></select></td></tr>
                     <tr class="buttons">
                
               </table>
               <input type="submit" name="Aceptar" value="Guardar cambios" >
               </form>
               <input type="button" name="Cancelar" value="Cancelar" onClick="window.location.href='profile.jsp'"></tr>
            </center>
         </div>
      </div>




 <iframe src="../footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>

   </body>
</html>