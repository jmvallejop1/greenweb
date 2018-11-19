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
  	CartelDO cartelActual = new CartelDO();
	PreguntaDO pregAct = new PreguntaDO();
	NoticiaDO notAct = new NoticiaDO();
	CartelesManager cman = new CartelesManager();
	PreguntasManager pman= new PreguntasManager();
	CartelDO c = cman.obtenerRetoActual();
	pregAct = c.getPreg();
	notAct = c.getNot();
  %>
  
  <section>
    <div class="container">
      <div id="RetoActual">
      
        
        
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
      <h3 class=cabeza>Seccion preguntas adicionales</h3>
      
      <% 
        // Obtencion de las preguntas con el usuario
        String user=request.getParameter("user");
      	if(pman.haRespondidoRA(user))	{
	      List<PreguntaDO> pregs = pman.obtenerPregsAdi(user);
	        //Obtencion de las preguntas
	         for (int i = 0; i < pregs.size(); i++){
	        	PreguntaDO p=pregs.get(i);
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
      			   <input type="submit"/>
    			</form>
   	   <%
   	        }
   	   }
      else{
    	  %>
    	  <h4 class=cabeza>TIENES QUE CONTESTAR A LA PREGUNTA DEL RETO ACTUAL PARA PODER PARTICIPAR EN LAS ADICIONALES</h4>
    	  <%
      }
   	   %>

  </section>

   <iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>


  </body>
</html>
