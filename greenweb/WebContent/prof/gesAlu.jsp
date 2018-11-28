<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>

<!DOCTYPE html>
<html lang="en">
   <head>
		<title>Gestionar alumnos</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../css/gestUsers.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script language="JavaScript">	
			function myFunction() {
				
				var url_string = window.location.href; // www.test.com?filename=test
				
				var pos = url_string.search("param")
				pos = pos + 6
				var er  = url_string.substr(pos,3)    		
    			if(er != null)
    				if(er == "nou")
    					window.alert("El usuario que ha introducido no existe en el sistema");
					if(er == "alu")
						window.alert("El usuario introducido es ahora un alumno");
				}
		</script>
		<script>
			$(document).ready(function() {
		 		$("#anadirUsuario").click(function(){
		 			var nombreUsuario = $("#nombreAlu").val();
		        	$.post("../Anadir", {
						tipo: 2,
						usuario: nombreUsuario
						}, function() {
					});
		    	});
			});
		</script>
		
		<script>
			$(document).ready(function() {
		 		$(".borrarAlu").click(function(){
		 			var nombreUsuario = $(this).prev().text();
		 			alert(nombreUsuario);
		        	$.post("../Anadir", {
						tipo: 3,
						usuario: nombreUsuario
						}, function() {
					});
		    	});
			});
		</script>
		
		<script>
		$(document).ready(function() {
			$('.addAluEntrega').click(function(event) {
				var id=$(this).parent().attr("fecha");
				//alert(id);
				$.post('../SeleccionGanador', {
					idcartel: id
				}, function(responseText) {
					comprobar(responseText);
				});
			});
		});
		</script>
		
   </head>

   <body onload="myFunction()">
		<iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
		<%
			UsuarioManager  man = new UsuarioManager();
			List<UsuarioDO> todos = man.obtenerUsuariosTipo("a");
		%>
		<div class="info">
			<h3 align="center">Lista de alumnos</h3>
			<p>Aquí podrás añadir y eliminar cuentas de la lista de alumnos. Aquel que esté en esta lista podrá acceder a los trabajos y votar su favorito. También podrá subir enlaces y votar si son fiables. Solo deben aparecer en esta lista los alumnos que estén en el curso actual.</p>
			<ul>
				<li>Para añadir un alumno nuevo busque su nombre y pulse el botón de añadir.</li>
				<li>Para eliminar un alumno pulse la cruz roja al lado de su nombre en la lista.</li>
				<li>Para añadir un alumno a la entrega actual introduzca el username del usuario.</li>
			</ul>
				
		</div>
		<div class="gestionUsers">
			<h4>Añadir alumnos</h4>
				<input type="text" id="nombreAlu"name="alumno" placeholder="Usuario a añadir">
				<input type="submit" id="anadirUsuario"name="busquedaUser" value="Añadir usuario">
			<hr>
			<h4>Añadir alumno a la entrega actual</h4>
			<form action="../AsociarUserEntrega" method="post" enctype="multipart/form-data">
				<input type="text" name="username" placeholder="Usuario a añadir">
				<input type="submit" id="anadirAEnt" value="Añadir">
			</form>
			<hr>
			<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar alumno...">
			<table id="myTable">
			  	<tr class="header">
			    	<th style="width:55%;">Nombre</th>
			    	<th style="width:25%;"> Nombre Usuario </th>
			    	<th style="width:20%">Borrar</th>
			 	</tr>
			 	<%
			 		for (int i = 0; i < todos.size();i++){
			 	%>
			 	<tr>
			    	<td><%out.println(todos.get(i).getNombre());%></td>
			    	<td><%out.println(todos.get(i).getUsername());%></td>
			    	<td class="borrarAlu"><img src="../images/borrar.png"></td>
			 	</tr> 
			 	
			 	 <%		
					} 
	 			 %>		 
			</table>
		</div>
		<iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>
	</body>
</html>