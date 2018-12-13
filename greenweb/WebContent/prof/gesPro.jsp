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
						window.alert("El usuario introducido es ahora un profesor.");
				}
		</script>
		
		<script>
			$(document).ready(function() {
		 		$("#anadirProf").click(function(){
		 			var nombreUsuario = $("#nombreAlu").val();
		        	$.post("../Anadir", {
						tipo: 1,
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
		
   </head>

   <body onload="myFunction()">
		<iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
		<%
			UsuarioManager  man = new UsuarioManager();
			List<UsuarioDO> todos = man.obtenerUsuariosTipo("p");
		%>
		<div class="info">
			<h3 align="center">Lista de alumnos</h3>
			<p>Aquí podras añadir y eliminar cuentas de la lista de profesores. </p>
			<ul>
				<li>Para añadir un profesor nuevo busque su nombre y pulse el botón de añadir.</li>
				<li>Para eliminar un profesor pulse la cruz roja al lado de su nombre en la lista.</li>
			</ul>
				
		</div>
		<div class="gestionUsers">
			<h4>Añadir alumnos</h4>
				<input type="text" id="nombreAlu" name="alumno" placeholder="Profesor a añadir">
				<input type="submit" id="anadirProf" value="Añadir profesor">
			<hr>
			<table id="myTable">
			  	<thead class="header">
			  		<tr>
				    	<th style="width:55%;">Nombre</th>
				    	<th style="width:25%;"> Nombre Usuario </th>
				    	<th style="width:20%">Borrar</th>
			    	</tr>
			 	</thead>
			 	<%
			 		for (int i = 0; i < todos.size();i++){
			 	%>
			 	<tr>
			    	<td><%out.println(todos.get(i).getNombre());%></td>
			    	<td><%out.println(todos.get(i).getUsername());%></td>
			    	<td class="borrarAlu"><img src="../images/borrar.png" ></td>
			 	</tr> 
			 	
			 	 <%		
					} 
	 			 %>		 
			</table>
		</div>
		<iframe src="../footer.html" class="frames" scrolling="no" border="no" width="100%" height="130" frameborder="no"></iframe>
	</body>
</html>