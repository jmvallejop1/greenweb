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
<html lang="en">
  <head>
    <title>Hello!</title>
    <!-- import the webpage's stylesheet -->
    <link rel="stylesheet" href="css/style.css">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    
  </head>
  <script language="JavaScript">	
			function myFunction() {
				
				var url_string = window.location.href; // www.test.com?filename=test
				
				var pos = url_string.search("param")
				pos = pos + 6
				var er  = url_string.substr(pos,3)    		
    			if(er != null && er != "")
    				if(er == "loo")
    					window.alert("Se ha cerrado sesion correctamente. ");
				}
		</script> 
  <body>

  <!-- BARRA DE NAVEGACION Y HEADER-->
  <iframe src="menu_global.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
  <jsp:useBean id="man" class="com.greenweb.cartel.CartelesManager"/>
  <c:set var="reto" value="${man.cartel}"/>
   
  <section>
    <div class="container">
      <div id="RetoActual">
        
        <h2>Reto Actual</h2>
      </div>
      
      <div class="reto">
        <h3><c:out value="${reto.noti.titulo}"></c:out></h3>
            <p><video  controls="controls">
              <source src="video/vid1.mp4" type="video/mp4">
            </video>
            	<c:out value="${reto.noti.texto}"></c:out>
            </p>
           
        </div>
      </div>
     <div class="PreguntaPrincipal">
          <h3><c:out value="${reto.preg.preg}"></c:out></h3>
          <div class="respuestas">
          <form>
          <ul>
              <li><input type="radio" name="resp" value="1" />
              <label><c:out value="${reto.preg.r1}"></c:out></label></li>
              <li><input type="radio" name="resp" value="2" />
              <label><c:out value="${reto.preg.r2}"></c:out></label></li>
              <li><input type="radio" name="resp" value="3" />
              <label><c:out value="${reto.preg.r3}"></c:out></label></li>
              <li><input type="radio" name="resp" value="4" />
              <label><c:out value="${reto.preg.r4}"></c:out></label></li>
          </ul>
          <input type="submit" class="bot" name="Aceptar" value="Contestar!">
          </form>
        </div>
      </div>
  </section>

   <iframe src="footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>


  </body>
</html>
