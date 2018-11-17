<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"
%>

<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
    <title>Preguntas Recicladas</title>
    <link rel="stylesheet" href="css/preguntas.css"> 
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"crossorigin="anonymous">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
	$(document).ready(function(){
    	$(".bot").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    		});
    		alert(array);
        	var id = $(this).parent().parent().parent().parent().attr("id");	
        	$.post('Contestar', {
				idc: id,
				resp: array
			}, function(data) {
				alert(data);
			});
   	 });
	});
</script>

  </head>  

  <body>
    <iframe src="menu_global.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
  	<!-- BARRA DE NAVEGACION Y HEADER-->
	<div class="info">
    	<p align="center"><strong>Â¡Bienvenidos a nuestra secciÃ³n de preguntas recicladas!</strong></p>
  		<p align="left">En esta secciÃ³n encontrareis una colecciÃ³n de preguntas provinientes de retos de otros aÃ±os. Â¡AsÃ­ nunca se pierden! PodrÃ¡s contestar a las preguntas y aparecerÃ¡ al instante la respuesta correcta. Sin embargo las preguntas que tengas como adicionales en tu reto actual no mostrarÃ¡n la respuesta correcta hasta que no termine el reto. Â¡No queremos trampas!</p>
  	</div>
  	<%
		PreguntasManager man=new PreguntasManager();
		List<PreguntaDO> result=man.obtenerTodasPreguntas();
	%>
	<div class="container">
	<%for(int i = 0;i<5;i++){ %>
		
	  <div id="<%out.println(result.get(i).getId());%>"> 
		<div class="PreguntaAdicional">
		    <form>
		      <h3><%out.println(result.get(i).getPreg());%></h3>
		      <i class="fas fa-info-circle"></i>
		      <div class="respuestas">
		        <ul>
		          <li><input type="checkbox" name="resp" value="1" />
		          <label><%out.println(result.get(i).getR1());%></label></li>
		          <li><input type="checkbox" name="resp" value="2" />
		          <label><%out.println(result.get(i).getR2());%></label></li>
		          <li><input type="checkbox" name="resp" value="3" />
		          <label><%out.println(result.get(i).getR3());%></label></li>
		          <li><input type="checkbox" name="resp" value="4" />
		          <label><%out.println(result.get(i).getR4());%></label></li>
		        </ul>
		        <input type="submit" class="bot" name="contestar" value="Contestar!">
		        </div>
	   	 </form>
	  	</div>
	  </div>
	  <%} %>
	</div>
  <iframe src="footer.html" class="frames" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>
</body>


