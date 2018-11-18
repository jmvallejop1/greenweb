<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
   <head>
		<meta charset="utf-8">
		<title> Mi cuenta </title>
		<link rel="stylesheet" href="../css/styleProfile.css">
      <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
   </head>
   <body>
   <c:set var="id" value="Welcome" scope="session" />
     	<jsp:useBean id="man" class="com.greenweb.usuario.data.UsuarioDO"/>
     	<jsp:setProperty name="man" property="loadUsername" value="${sessionScope.id}" />
    	
               
      <iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
   		<!--AquÃ­ irÃ­a el frame de la cabecera y el menu-->
      <div class="box2">
   		<img src="../images/perfil.jpg" alt="Su foto de perfil" id="ProfPic">
   		<div class="infoUser">
            <center>
      			<h2> InformaciÃ³n personal de <c:out value="${man.id}"></c:out></h2>
               <!--Recoger la info del usuario y rellenar los campos con la respuesta-->
               <table>
              <tr class="data"><td>Tipo de cuenta: </td><td><c:out value="${man.id}"></c:out></td></tr></tr>
                  <tr class="data"><td>Id de usuario: </td><td><c:out value="${man.id}"></c:out></td></tr>
                  <tr class="data"><td>Correo electrÃ³nico: </td><td> <c:out value="${man.id}"></c:out></td></tr>
                 <tr class="data"><td>Edad: </td><td><c:out value="${man.id}"></c:out></td></tr>
                 <tr class="data"><td>Ocupacion actual: </td><td><c:out value="${man.id}"></c:out></td></tr>
                  <tr><td><a href="editProfile.jsp">Editar datos</a></td></tr>
                   <tr><td><a href="borrarUser.jsp">Dar usuario de baja</a></td></tr>
               </table>
            </center>
      </div>
     
      </div>
      <div class="botones">
          <input type="button" name="gestAlu" value="Gestionar alumnos" onClick="window.location.href='gesAlu.html'"> 
          <input type="button" name="gestPro" value="Gestionar profesores" onClick="window.location.href='gesPro.html'">
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
            
