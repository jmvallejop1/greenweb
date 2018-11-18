<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Mi cuenta</title>
      <link rel="stylesheet" href="../css/styleProfile.css">
      <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
   </head>
   <body>
   <%
   		UsuarioManager un = new UsuarioManager();
   		//UsuarioDO usu= un.obtenerUsuario((String)session.getAttribute("id"));
   		UsuarioDO usu= un.obtenerPepe();
   %>
      <iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
         <!--AquÃ­ irÃ­a el frame de la cabecera y el menu-->
      <div class="box2">
         <img src="../images/perfil.jpg" alt="Su foto de perfil" id="ProfPic">
         <div class="infoUser">
            <center>
               <h2> InformaciÃ³n personal de Nombre Apellido</h2>
               <!--Recoger la info del usuario y rellenar los campos con la respuesta-->
               <table>
                  <tr class="data"><td>Tipo de cuenta: </td><td><%out.println(un.tipo(usu.getTipo()));%></td></tr></tr>
                  <form action="../CambiarDatos" method="post">
                     <tr class="data"><td>Id de usuario: </td><td><input name="idUser" placeholder="<%out.println(usu.getUsername());%>"/></td></tr>
                     <!-- AquÃ­ se debe comprobar que el nombre de usuario esta libre -->
                     <tr class="data"><td>Correo electrÃ³nico: </td><td><input name="email"type="email" placeholder="<%out.println(usu.getMail());%>"></td></tr>
                     <tr class="data"><td>Edad: </td><td><input type="age" name="age" placeholder="<%out.println(usu.getEdad());%>"></td></tr>
                     <tr class="data"><td>Ocupacion actual: </td>
                        <td><select name="ocupacion"><option value ="0"> Selecciona ocupacion</option><option value ="1">Ingeniero</option><option value ="2">Medico</option><option value ="3">Empresario</option><option value ="4">Estudiante TIC</option><option value ="5">Estudiante Ciencias Sociales</option><option value ="6">Estudiante Ciencias Salud</option><option value ="7">Estudiante Letras</option></select></td></tr>
                     <tr class="buttons">
                
               </table>
               <input type="submit" name="Aceptar" value="Guardar cambios">
               </form>
               <input type="button" name="Cancelar" value="Cancelar" onClick="window.location.href='profile.jsp'"></tr>
            </center>
         </div>
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

 <iframe src="../footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>

   </body>
</html>