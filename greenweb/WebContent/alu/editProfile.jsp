<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Mi cuenta</title>
      <link rel="stylesheet" href="../css/styleProfile.css">
      <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
   </head>
   <body>
      <iframe src="menu_alumno.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
         <!--Aquí iría el frame de la cabecera y el menu-->
      <div class="box2">
         <img src="../images/perfil.jpg" alt="Su foto de perfil" id="ProfPic">
         <div class="infoUser">
            <center>
               <h2> Información personal de Nombre Apellido</h2>
               <!--Recoger la info del usuario y rellenar los campos con la respuesta-->
               <table>
                  <tr class="data"><td>Tipo de cuenta: </td><td>Usuario</td></tr></tr>
                  <form action="/" method="post">
                     <tr class="data"><td>Id de usuario: </td><td><input type="idUser" placeholder="user1"/></td></tr>
                     <!-- Aquí se debe comprobar que el nombre de usuario esta libre -->
                     <tr class="data"><td>Correo electrónico: </td><td><input type="email" placeholder="usuarioPrueba@gmail.com"></td></tr>
                     <tr class="data"><td>Edad: </td><td><input type="age" placeholder="20"></td></tr>
                     <tr class="data"><td>Ocupacion actual: </td>
                        <td><select name="ocupacion"><option>Ingeniero</option><option>Medico</option><option>Empresario</option><option>Estudiante TIC</option><option>Estudiante Ciencias Sociales</option><option>Estudiante Ciencias Salud</option><option>Estudiante Letras</option></select></td></tr>
                     <tr class="buttons">
                  </form>
               </table>
               <input type="submit" name="usuarioIncorrecto" value="Guardar(usuario incorrecto)" onClick="window.location.href='profileMal.html'">
               <input type="submit" name="Aceptar" value="Guardar cambios" onClick="window.location.href='profileCambiado.html'">
               <input type="button" name="Cancelar" value="Cancelar" onClick="window.location.href='profile.html'"></tr>
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