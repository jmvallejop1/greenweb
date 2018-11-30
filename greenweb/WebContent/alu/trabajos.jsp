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
			$('.LikeAlu').click(function(event) {
				var id=$(this).parent().attr("id");
				//alert(id);
				$.post('../SumaVotoTrabajo', {
					idcartel: id
				}, function(responseText) {
					if (responseText==0) window.alert('¡Ha votado el trabajo!')
					else window.alert('Su voto no ha podido ser procesado')
				});
			});
		});
	 </script>
	 <script>
	$(document).ready(function() {
		$('.Trabajo').click(function(event) {
			var id = $(this).parent().parent().attr("id");
			//alert(id);
			$.ajax({
                type: "POST",
                url: '../RetoPreg',
                data: ({ idn: id}),
                success: function(data) {
                	//alert("TodoOK");
                	window.open(data+"/retoP.jsp");   
                },
                error: function() {
                    alert('Error occured 23');
                }
            });
		});
	});
	</script>
	<script language="JavaScript">	
			function myFunction() {
				
				var url_string = window.location.href; // www.test.com?filename=test
				
				var pos = url_string.search("error")
				pos = pos + 6
				var er  = url_string.substr(pos,3)    		
    			if(er != null)
    				if(er == "not")
    					window.alert("El trabajo no se ha subido correctamente.");
				}
		</script>
</head>
<body onload="myFunction()">
	<!-- BARRA DE NAVEGACION Y HEADER-->
   <iframe src="menu_alumno.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	
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
			   			<img src="../images/<%out.print(c.getFoto());%>" alt="Imagen trabajo">
			   			<p>		
			   				<%out.println(c.getNoti().getTitulo());%>
			   			</p>
			   		</div>
			   		<button class="LikeAlu">Votar como el mejor</button>  	
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
   
 <iframe  src="../footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="125" frameborder="no"></iframe>
</body>
</html>