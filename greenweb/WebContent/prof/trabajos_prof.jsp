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
<html>
<head>
	<meta charset="utf-8">
	<title>Trabajos</title>
	 <link rel="stylesheet" href="../css/trabajos.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	 <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
	 <link href="https://fonts.googleapis.com/css?family=Niramit:400,700" rel="stylesheet"> 
	 <script>
	 $(document).ready(function() {
			$('.SelectDef').click(function(event) {
				var id=$(this).parent().attr("id");
				$.post('../SeleccionGanador', {
					idcartel: id
				}, function(responseText) {
					comprobar(responseText);
				});
			});
		});
	 </script>
	 <script>
	$(document).ready(function() {
		$('.Trabajo').click(function(event) {
			var id = $(this).parent().parent().attr("id");
			$.ajax({
                type: "POST",
                url: '../RetoPreg',
                data: ({ idn: id}),
                success: function(data) {
                	window.open(data+"/retoP.jsp");   
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
			if(valor == 0){
				window.alert("Asegurese de que hay una nueva entrega");
			}
			else{
				window.alert("Se ha establecido el reto seleccionado como definitivo");
			}
		}
	</script>	 
</head>
<body>
	<!-- BARRA DE NAVEGACION Y HEADER-->
   <iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	
	<h1> ¡Tablón con todos los carteles!</h1>
	<%
		CartelesManager cman=new CartelesManager();
		//List<CartelDO> lista=cman.obtenerCartelesEntrega(11);
		List<CartelDO> lista=cman.obtenerCartelesActuales();
	%>
	<input type="button" class="BotTrab" name="Cancelar" value="Añadir cartel" onclick="window.location.href='subir_archivos.jsp'"/>
	   <div class="Trabajos">
	   <%
	   if(lista!=null && lista.size()>0){
	   	for(CartelDO c: lista){
	   		%>
	   		<div class="TrabajoVoto">
	   		<div id=<%out.print(c.getIdPreg());%>>
	   			<div id=<%out.print(c.getId());%>>
			   		<div class="Trabajo">
			   			<img src="../<%out.print(c.getFoto());%>" alt="Imagen trabajo">
			   			<p>		
			   				<%out.println(c.getNoti().getTitulo());%>
			   			</p>
			   		</div>
			   		<button class="SelectDef">Seleccionar como definitivo</button>  	
		   		</div>
	   		</div>	
	   		</div>
	   		<%
	   	}
	   }
	   else{
		   %>
		   <center><p>No hay trabajos entregados</p></center>
		   <%
	   }
	   %>
   	   </div>
   	   
 <iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="125" frameborder="no"></iframe>
</body>
</html>