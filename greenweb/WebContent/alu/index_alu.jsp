<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Hello!</title>
    <!-- import the webpage's stylesheet -->
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    
  </head>  
  <body>



  <!-- BARRA DE NAVEGACION Y HEADER-->
  <iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>

  <%/*out.println(request.getParameter("user"));
	out.println(request.getParameter("pass"));
	out.println("Hello");
	session.setAttribute("logged","yes");
	out.println(session.getAttribute("logged"));*/
  %>
  
  <% 
   	int idCartelActual = pman.idPregActual();
    CartelDO cartelActual = cman.obtenerCartelP(idCartelActual);
    PreguntaDO pregAct = cartelActual.getPreg();
    NoticiaDO notAct = cartelActual.getNot();
  %>
  
  <section>
    <div class="container">
      <div id="RetoActual">
        <h2>Reto Actual</h2>
      </div>
      
      <div class="reto">
        <h3><%out.println(notAct.getTitulo());%></h3>
            <p><video  controls="controls">
              <source src="../video/vid1.mp4" type="video/mp4">
            </video>
            	<%out.println(notAct.getTexto());%>
            </p>
            
        </div>
      </div>
    </div> 
     <div class="pregunta">
          <h3><%out.println(pregAct.getPreg());%></h3>
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
          <input type="button" name="contestar" value="Contestar!" onclick="window.location.href='index_respondeRA.html'">
          <!--input type="submit" class="bot" name="Aceptar" value="Contestar!"-->
          </form>
      </div>
      <center>
      <h3>Seccion preguntas adicionales</h3>
      </center>
      
      <% 
        // Obtencion de las preguntas con el usuario
      	int [] pregAdicionales = getPregsAdi(request.getParameter("user"));
      	
      %>
      
      <%
        //Obtencion de las preguntas
         for (int i = 0; i < pregAdicionales.size(); i++){
        	PreguntaDAO dao = new PreguntaDAO();
        	PreguntaDO p = new PreguntaDO();
        	if (dao.obtenerPregunta(pregAdicionales[i], p)){
        	
       %>
      			<form class="pregunta" action="#" method="post">
     		   	 <h3><%out.println(p.getPreg());%></h3>
      				<ul>
         			 	<li><input type="radio" name="resp" value="1" />
          			 	<label><%out.println(p.getR1());%></label></li>
         			 	<li><input type="radio" name="resp" value="2" />
         			 	<label>><%out.println(p.getR2());%></label></li>
         			 	<li><input type="radio" name="resp" value="3" />
         				<label>><%out.println(p.getR3());%></label></li>
         			    <li><input type="radio" name="resp" value="4" />
          				<label>><%out.println(p.getR4());%></label></li>
     			 	</ul>
      			   <input type="submit"/></button>
    			</form>
   	   <%
   	        }
   	      }  
   	   %>

  </section>

   <iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>


  </body>
</html>
