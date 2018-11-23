<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../css/subidacartel.css">
		<link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet"> 
		<title> subir_archivos </title>
	</head>
	
	<body>
			<div class="loginBox">   
				<form action="../AnadirCartel" method="post" enctype="multipart/form-data">
					<center>
						<img src="images/upload.jpg"/>
						<h1> Entrega tu cartel </h1>
							<table>
								<tr>
									<td> <p> Titulo del trabajo </p></td> <td><input type="text" name="titulo"/> </td>
								</tr>		
								<tr>
									<td> <p> Texto </p></td> <td><input type="text" name="texto" maxlength="500"/></td>
								</tr>		  
								<tr>
									<td> <p> Video </p> </td> <td><input type="file" name="video" mutiple="multiple"/>/></td>
								</tr>					
								<tr> 
									<td> <p>Imagenes </p></td> <td><input type="file" name="foto" mutiple="multiple"/></td>
								</tr>					
								<tr>
									<td> <p>Pregunta </p> </td> <td><input type="text" name="pregunta"/></td>
								</tr>					
								<tr>
									<td> <p> Primera respuesta </p> </td> <td><input type="text" name="respuesta_uno"/></td>
								</tr>       
								<tr>
									<td> <p>Segunda respuesta </p> </td> <td><input type="text" name="respuesta_dos"/></td>
								</tr>		  
								<tr>
									<td> <p> Tercera respuesta </p> </td> <td><input type="text" name="respuesta_tres"/></td>
								</tr>				
								<tr>
									<td> <p> Cuarta respuesta </p> </td> <td><input type="text" name="respuesta_cuatro"/></td>
								</tr>
								<tr>
									<td> <p>Respuesta correcta </p> </td> <td><input type="number" name="respuesta_correcta"/></td>
								</tr>
								<tr>
									<td> <p>Primer miembro </p> </td> <td><input type="text" name="autor1"/></td>
								</tr>
								<tr>
									<td> <p>Segundo miembro </p> </td> <td><input type="text" name="autor2"/></td>
								</tr>
								<tr>
									<td> <p>Tercer mimebro </p> </td> <td><input type="text" name="autor3"/></td>
								</tr>
								<tr>
									<td> <p>Cuarto mimebro </p> </td> <td><input type="text" name="autor4"/></td>
								</tr>
								<tr>
									<td> <p>Quinto mimebro </p> </td> <td><input type="text" name="autor5"/></td>
								</tr>
							</table>	
						
						<input type="submit" name="Cancelar" value="Enviar" onClick="window.location.href='index_alu.html'" >
					</center>
				</form>
			</div>
	</body>
</html>