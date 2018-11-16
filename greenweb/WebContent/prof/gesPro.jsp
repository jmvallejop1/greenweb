<!DOCTYPE html>
<html lang="en">
   <head>
		<title>Gestionar profesores</title>
		<link rel="stylesheet" href="css/gestUsers.css">
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
   </head>

   <body onload="myFunction()">
		<iframe src="menu_prof.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
		<div class="info">
			<h3 align="center">Lista de profesores</h3>
			<p>Aquí podrás añadir y eliminar cuentas de la lista de profesores. Aquel que esté en esta lista podrá acceder a los trabajos y votar su favorito. Un profesor podrá añadir cuentas a las listas de alumnos y profesores por lo que deben estar muy controlados. También podrá subir enlaces y votar si son fiables. Solo deben aparecer en esta lista los profesores que estén impartiendo el curso actual o encargados de la gestión de la página.</p>
			<ul>
				<li>Para añadir un alumno nuevo busque su nombre y pulse el botón de añadir.</li>
				<li>Para eliminar un alumno pulse la cruz roja al lado de su nombre en la lista.</li>
			</ul>
				
		</div>
		<div class="gestionUsers">
			<form action="../AnadirProf" method="post">
			<h4>Añadir profesores</h4>
				<input type="text" name="prof" placeholder="Profesor a a�adir">
				<input type="submit" name="busquedaUser" value="Añadir profesor">
			</form>
			<hr>
			<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar profesor...">
			<table id="myTable">
			  	<tr class="header">
			    	<th style="width:55%;">Nombre Usuario</th>
			    	<th style="width:25%;">Id Cuenta</th>
			    	<th style="width:20%">Borrar</th>
			 	</tr>
			 	<tr>
			    	<td>Alfreds Futterkiste</td>
			    	<td>AlFutt</td>
			    	<td><img src="images/borrar.png"></td>
			 	</tr>
			  	<tr>
			    	<td>Berglunds snabbkop</td>
			    	<td>Swediepie</td>
			    	<td><img src="images/borrar.png"></td>
			 	</tr>
			  	<tr>
				    <td>Island Trading</td>
				    <td>Tradisl</td>
			    	<td><img src="images/borrar.png"></td>
			  	</tr>
			 	<tr>
				    <td>Koniglich Essen</td>
				    <td>Koningen</td>
			    	<td><img src="images/borrar.png"></td>
			  	</tr>
			</table>
		</div>
		 <iframe src="../footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>
	</body>
</html>