<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
    <title>Preguntas Recicladas</title>
    <link rel="stylesheet" href="css/preguntas.css"> 
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"crossorigin="anonymous">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	
    <script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			$.post('mas5/mas5preg.jsp', {
			}, function(responseText) {
				$('.container').html(responseText);
			});
		});
	});
	</script>
<script>
	var cambio;
	$(document).ready(function(){
    	$(".bot").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    			$(this).prop('checked', false);
    		});
    		alert(array);
        	var id = $(this).parent().parent().parent().parent().attr("id");
        	cambio = $(this).parent().parent().parent().parent().parent();
        	$.ajax({
                type: "POST",
                url: 'Contestar',
                data: ({ idc: id , resp: array }),
                success: function(data) {
                    comprobar(data);    
                },
                error: function() {
                    alert('Error occured 23');
                }
            });
        	
   	 });
	});
</script>

<script>
	function comprobar(valor){
		if(valor == -1){
			window.alert("-1");
		}else if(valor == 0){
			$(cambio).addClass("correcta");
			window.alert("0");
		}else if(valor>0){	
			$(cambio).addClass("incorrecta");
			window.alert(valor);
		}
	}
</script>


  </head>  

  <body>
    <iframe src="menu_global.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<div class="info">
    	<p align="center"><strong>Â¡Bienvenidos a nuestra secciÃ³n de preguntas recicladas!</strong></p>
  		<p align="left">En esta secciÃ³n encontrareis una colecciÃ³n de preguntas provinientes de retos de otros aÃ±os. Â¡AsÃ­ nunca se pierden! PodrÃ¡s contestar a las preguntas y aparecerÃ¡ al instante la respuesta correcta. Sin embargo las preguntas que tengas como adicionales en tu reto actual no mostrarÃ¡n la respuesta correcta hasta que no termine el reto. Â¡No queremos trampas!</p>
  	</div>
  	<jsp:useBean id="man" class="com.greenweb.pregunta.PreguntasManager"/>
  	<c:if test = "${sessionScope.hasta > fn:length(man.preguntas)}">
         	<c:set var = "hasta" scope = "session" value = "${fn:length(man.preguntas)}"/>
    </c:if> 	
	<div class="container">
	<c:forEach var="pregunta" end="5" items="${man.preguntas}">
	<div>
	  <div id="<c:out value="${pregunta.id}"></c:out>"> 
		<div class="PreguntaAdicional">
		    <form>
		      <h3><c:out value="${pregunta.preg}"></c:out></h3>
		      <i class="fas fa-info-circle"></i>
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
		        <input type="button" class="bot" name="contestar" value="Contestar!">
		        </div>
	   	 </form>
	  	</div>
	  </div>
	  </div>
	  </c:forEach>
	</div>	
	<input type="button" id="submit" value="Mostrar Preguntas" /> 
  <iframe src="footer.html" class="frames" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>
</body>


