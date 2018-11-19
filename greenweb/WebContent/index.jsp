<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
import="com.greenweb.cartel.*,java.util.List,com.greenweb.cartel.data.*"
import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*"
import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"
%>

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

  <%
  PreguntasManager pman = new PreguntasManager();
  CartelesManager cman = new CartelesManager();
  %>
   
  <section>
    <div class="container">
      <div id="RetoActual">
      
        <% 
        	CartelDO cartelActual = new CartelDO();
    		PreguntaDO pregAct = new PreguntaDO();
    		NoticiaDO notAct = new NoticiaDO();
        
        	CartelDO c = cman.obtenerRetoActual();
        	pregAct = c.getPreg();
        	notAct = c.getNot();
        %>
        
        <h2>Reto Actual</h2>
      </div>
      
      <div class="reto">
        <h3><%out.println(notAct.getTitulo());%></h3>
            <p><video  controls="controls">
              <source src="video/vid1.mp4" type="video/mp4">
            </video>
            	<%out.println(notAct.getTexto());%>
            </p>
           
        </div>
      </div>
     <div class="PreguntaPrincipal">
          <h3><%out.println(pregAct.getPreg());%></h3>
          <div class="respuestas">
          <form>
          <ul>
              <li><input type="radio" name="resp" value="1" />
              <label><%out.println(pregAct.getR1());%></label></li>
              <li><input type="radio" name="resp" value="2" />
              <label><%out.println(pregAct.getR2());%></label></li>
              <li><input type="radio" name="resp" value="3" />
              <label><%out.println(pregAct.getR3());%></label></li>
              <li><input type="radio" name="resp" value="4" />
              <label><%out.println(pregAct.getR4());%></label></li>
          </ul>
          <input type="submit" class="bot" name="Aceptar" value="Contestar!">
          </form>
        </div>
      </div>
  </section>

   <iframe src="footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>


  </body>
</html>
