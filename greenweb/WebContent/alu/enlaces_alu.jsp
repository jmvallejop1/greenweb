<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.enlace.*,java.util.List,com.greenweb.enlace.data.*"
%>
<html lang="en">
 <head>
	<title> Enlaces </title>
	<link rel="stylesheet" href="../css/enlaceStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		$('#submitalu').click(function(event) {
			$.post('mas5alu.jsp', {
				num: 2
			}, function(data,status) {
				$('.tabla').html(data);
			});
		});
	});
	</script>
	<script>
	$(document).ready(function() {
		 $(".vota").click(function(){
			 	var miVar =  $(this).prev().prev().text();
		        alert("Text: " + $(this).prev().prev().text());
		        $.post("../SumaVoto", {
					id: miVar
				}, function() {
				});
		    });
	});
	
	</script>
	<script>
	$(document).ready(function() {
		 $(".subir").click(function(){
			 	var miVar = $("#InputEnlace").val();
		        alert("Text: " + $("#InputEnlace").val());
		        $.post("../SubirEnlace", {
					id: miVar
				}, function() {
				});
		    });
	});	
	</script>
	
	

 </head>
   
  <body>
  <!-- HEADER Y NAVBAR -->
    <iframe src="menu_alumno.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
    
    <div class="info">
	 <p align="center"><strong>Â¡Bienvenidos a nuestra secciÃ³n de enlaces hacia fuentes de informaciÃ³n fiables!</strong></p>
	 <p align="left">En esta seciÃ³n encontrareis una colecciÃ³n de enlaces a medios de informaciÃ³n que proporcionan informaciÃ³n fiable y verÃ­dica. AdemÃ¡s cuanto mÃ¡s arriba estÃ© el enlace, querrÃ¡ decir que mÃ¡s alumnos y profesores del departamento de ingenierÃ­a quÃ­mica y del medio ambiente de la universidad de Zaragoza lo han seleccionado como fiable. Â¡InfÃ³rmate de una manera responsable aquÃ­!</p>
	<%
		EnlacesManager man=new EnlacesManager();
		List<EnlaceDO> todos=man.obtenerTodosEnlaces();
		int hasta =5;
		if(todos.size()<5){
			hasta  = todos.size();
		}
		
	%>	
	</div>
	  <div class="container">
	  	<center>
	  	 <input type="url" id="InputEnlace" placeholder="        Añade tu enlace"></td></tr>
		 <input type="button" name="subirLink" class="subir" value="Subir enlace">
		 <table class="tabla">
			<thead>
				<tr><th>Enlaces mejor valorados</th><th>Votos verdes</th><th>Vota</th></tr>
			</thead>
	
	<% 			
			for(int i=0;i<hasta;i++){
	%>
			<tr><td><a href="#"><%out.println(todos.get(i).getURL());%></a></td> <td><% out.println(todos.get(i).getVotos()); %></td><td class="vota"><img src="../images/fiable.png"></td></tr>	
	<%		} %>

	  	</table>
	  	<input type="button" id="submitalu" value="Mostrar Enlaces" /> 
	  </center>
   	</div>
   	 <iframe src="../footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>

  </body>
</html>

