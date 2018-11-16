<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>

<!DOCTYPE html>
<html lang="en">
   <head>
		<meta charset="utf-8">
		<title> Mi cuenta </title>
		<link rel="stylesheet" href="../css/styleProfile.css">
      <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
   </head>
   <body>
   <%
   		UsuarioManager un = new UsuarioManager();
   		//Descomentar esta linea cuando al iniciar se sesion se uarde el id
   		//UsuarioDO usu= un.obtenerUsuario((String)session.getAttribute("id"));
   		UsuarioDO usu = un.obtenerPepe();
   %>
      <iframe src="menu_alumno.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
   		<!--AquÃ­ irÃ­a el frame de la cabecera y el menu-->
      <div class="box2">
   		<img src="../images/perfil.jpg" alt="Su foto de perfil" id="ProfPic">
   		<div class="infoUser">
            <center>
      			<h2> InformaciÃ³n personal de <%out.println(usu.getNombre());%></h2>
               <!--Recoger la info del usuario y rellenar los campos con la respuesta-->
               <table>
                  <tr class="data"><td>Tipo de cuenta: </td><td><%out.println(un.tipo(usu.getTipo()));%></td></tr></tr>
                  <tr class="data"><td>Id de usuario: </td><td><%out.println(usu.getUsername());%></td></tr>
                  <tr class="data"><td>Correo electrÃ³nico: </td><td> <%out.println(usu.getMail());%></td></tr>
                  <tr class="data"><td>Edad: </td><td><%out.println(usu.getEdad());%></td></tr>
                  <tr class="data"><td>Ocupacion actual: </td><td><%out.println(un.ocupacion(usu.getEstudios()));%></td></tr>
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
            
