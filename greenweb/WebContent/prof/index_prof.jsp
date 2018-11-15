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
  <iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>

  <%/*out.println(request.getParameter("user"));
	out.println(request.getParameter("pass"));
	out.println("Hello");
	session.setAttribute("logged","yes");
	out.println(session.getAttribute("logged"));*/
  %>
  <section>
    <div class="container">
      <div id="RetoActual">
        <h2>Reto Actual</h2>
      </div>
      
      <div class="reto">
        <h3>Nombre del reto</h3>
            <p><video  controls="controls">
              <source src="../video/vid1.mp4" type="video/mp4">
            </video>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
            

        </div>
      </div>
    </div> 
     <div class="pregunta">
          <h3>hola que tal como estas?</h3>
          <form>
          <ul>
              <li><input type="radio" name="resp" value="1" />
              <label>op1</label></li>
              <li><input type="radio" name="resp" value="2" />
              <label>op2</label></li>
              <li><input type="radio" name="resp" value="3" />
              <label>op3</label></li>
              <li><input type="radio" name="resp" value="4" />
              <label>op4</label></li>
          </ul>
          <input type="button" name="contestar" value="Contestar!" onclick="window.location.href='index_respondeRA.html'">
          <!--input type="submit" class="bot" name="Aceptar" value="Contestar!"-->
          </form>
      </div>
      <center>
      <h3>Seccion preguntas adicionales</h3>
      </center>
      <form class="pregunta" action="#" method="post">
      <h3>Â¿QuÃ© efectos provoca la emision de gases en la capa de ozono?</h3>
      <ul>
          <li><input type="radio" name="resp" value="1" />
          <label>Malestar popular</label></li>
          <li><input type="radio" name="resp" value="2" />
          <label>Revueltas sociales</label></li>
          <li><input type="radio" name="resp" value="3" />
          <label>Cambio climÃ¡tico</label></li>
          <li><input type="radio" name="resp" value="4" />
          <label>Nose</label></li>
      </ul>
      <input type="submit"/></button>
    </form>
    <form class="pregunta" action="#" method="post">
      <h3>Â¿QuÃ© efectos provoca la emision de gases en la capa de ozono?</h3>
      <ul>
          <li><input type="radio" name="resp" value="1" />
          <label>Malestar popular</label></li>
          <li><input type="radio" name="resp" value="2" />
          <label>Revueltas sociales</label></li>
          <li><input type="radio" name="resp" value="3" />
          <label>Cambio climÃ¡tico</label></li>
          <li><input type="radio" name="resp" value="4" />
          <label>Nose</label></li>
      </ul>
      <input type="submit"/></button>
    </form>
    <form class="pregunta" action="#" method="post">
      <h3>Â¿QuÃ© efectos provoca la emision de gases en la capa de ozono?</h3>
      <ul>
          <li><input type="radio" name="resp" value="1" />
          <label>Malestar popular</label></li>
          <li><input type="radio" name="resp" value="2" />
          <label>Revueltas sociales</label></li>
          <li><input type="radio" name="resp" value="3" />
          <label>Cambio climÃ¡tico</label></li>
          <li><input type="radio" name="resp" value="4" />
          <label>Nose</label></li>
      </ul>
      <input type="submit"/></button>
    </form>
    <form class="pregunta" action="#" method="post">
      <h3>Â¿QuÃ© efectos provoca la emision de gases en la capa de ozono?</h3>
      <ul>
          <li><input type="radio" name="resp" value="1" />
          <label>Malestar popular</label></li>
          <li><input type="radio" name="resp" value="2" />
          <label>Revueltas sociales</label></li>
          <li><input type="radio" name="resp" value="3" />
          <label>Cambio climÃ¡tico</label></li>
          <li><input type="radio" name="resp" value="4" />
          <label>Nose</label></li>
      </ul>
      <input type="submit"/></button>
    </form>

  </section>

   <iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>


  </body>
</html>
