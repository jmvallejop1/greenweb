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
    <meta charset="utf-8">
    <!-- import the webpage's stylesheet -->
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
	var cambio;
	$(document).ready(function(){
    	$("#ContestarPrincipal").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    			$(this).prop('checked', false);
    		});
        	$.ajax({
                type: "POST",
                url: '../ContestarActual',
                data: ({ resp: array }),
                success: function(data) {    
                },
                error: function() {
                    alert('Error occured 23');
                }
            });
        	
   	 });
	});
</script>

 <script>
	var cambio;
	$(document).ready(function(){
    	$(".ContestarAdicional").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    			$(this).prop('checked', false);
    		});
        	var id = $(this).parent().parent().parent().parent().attr("id");
        	$.ajax({
                type: "POST",
                url: '../ContestarAdicional',
                data: ({ idc: id , resp: array }),
                success: function(data) {
                    comprobar(data);    
                },
                error: function() {
                    alert('Ha ocurrido un error.');
                }
            });
        	
   	 });
	});
</script>
<script>
function comprobar(valor){
		if(valor == "noOK"){
			window.alert("Esta pregunta ya ha sido contestada");
		}else if(valor == "ok"){
			window.alert("Pregunta repondida");
		}
}
</script>
   <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Archivo" rel="stylesheet">   

  </head>  
  <body>



  <!-- BARRA DE NAVEGACION Y HEADER-->
  <iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>    
  <section>
  
  
    <div class="container">
      <div id="RetoActual">
  		<jsp:useBean id="man" class="com.greenweb.cartel.CartelesManager"/>
  		<c:set var="reto" value="${man.cartel}"/>
    	    
        
        <h2>Reto Actual</h2>
      </div>

     <div class="reto">
        <h3><c:out value="${reto.noti.titulo}"></c:out></h3>
            <p><video  controls="controls">
              <source src="../<c:out value="${reto.noti.video}"></c:out>" type="video/mp4">
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
              <li><input type="checkbox" name="resp" value="1" />
              <label><c:out value="${reto.preg.r1}"></c:out></label></li>
              <li><input type="checkbox" name="resp" value="2" />
              <label><c:out value="${reto.preg.r2}"></c:out></label></li>
              <li><input type="checkbox" name="resp" value="3" />
              <label><c:out value="${reto.preg.r3}"></c:out></label></li>
              <li><input type="checkbox" name="resp" value="4" />
              <label><c:out value="${reto.preg.r4}"></c:out></label></li>
          </ul>
          <input type="button" id="ContestarPrincipal" name="Aceptar" value="Contestar!">
          </form>
        </div>
      </div>
      <h3 class="TituloAdicionales">Seccion preguntas adicionales</h3>     
      <jsp:useBean id="pre" class="com.greenweb.pregunta.PreguntasManager"/>
	  <jsp:setProperty name="pre" property="user" value="${sessionScope.id}" /> 
	  <c:choose>        
		<c:when test = "${pre.respondido == false}">
			No se ha respondido al reto actual...
		</c:when>              
		<c:otherwise>
		<div class="container">
			<c:forEach var="pregunta" items="${pre.adicionales}">
	  			<div id="<c:out value="${pregunta.id}"></c:out>"> 
					<div class="PreguntaAdicional">
		  			  <form>
		      			<h3><c:out value="${pregunta.preg}"></c:out></h3>
		     				<div class="respuestas">
		       					 <ul>
							          <li><input type="checkbox" name="resp" value="1" />
							          <label><c:out value="${pregunta.r1}"></c:out></label></li>
							          <li><input type="checkbox" name="resp" value="2" />
							          <label><c:out value="${pregunta.r2}"></c:out></label></li>
							          <li><input type="checkbox" name="resp" value="3" />
							          <label><c:out value="${pregunta.r3}"></c:out></label></li>
							          <li><input type="checkbox" name="resp" value="4" />
							          <label><c:out value="${pregunta.r4}"></c:out></label></li>
		       					 </ul>
		      					  <p></p>
		       					 <input type="button" class="ContestarAdicional" name="contestar" value="Contestar!">
		       					 </div>
	   	 				</form>
	  				</div>
	 			</div>	 
	  		</c:forEach>
	   </div>
	</c:otherwise>
	</c:choose>

  </section>

   <iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>


  </body>
</html>
