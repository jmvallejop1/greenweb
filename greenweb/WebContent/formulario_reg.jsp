<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/estilos_4.css">
		<link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet"> 
		<title> Registrase </title>
		<script language="JavaScript">	
			function myFunction() {
				
				var url_string = window.location.href; // www.test.com?filename=test
				
				var pos = url_string.search("error")
				pos = pos + 6
				var er  = url_string.substr(pos,3)    		
    			if(er != null)
    				if(er == "wpw")
    					window.alert("Las contraseñas no cionciden.");
    				if(er == "nlo")
    					window.alert("No se ha podido crear la cuenta correctamente.");
    				if(er == "npw")
    					window.alert("No se ha introducido una contraseña.");
    				if(er == "uex")
    					window.alert("El nombre de usuario esta cogido.");
    				if(er == "une")
    					window.alert("Escribe un nombre de usuario valido.");
				}
		</script>
		
	</head>	
	<body onload="myFunction()">
	
		<div class="tab-content">
			<div id="Registrarse">   
			
				<form method="post" action="Registro">
				
				  <h1> Â¡Registrate gratis! </h1>
          
					<div class="field-wrap">
						<input type="text" name="usuario"required autocomplete="off" placeholder="Nombre"/>
					</div>
					
					<div class="field-wrap">
						<input type="text" name="username" required autocomplete="off" placeholder="Username"/>
					</div>
		
					<div class="field-wrap">
						<input type="email" name="correo" required autocomplete="off" placeholder="Correo electronico"/>
					</div>
		  
					<div class="field-wrap">
						<input type="text" name="edad" required autocomplete="off" placeholder="Edad"/>
					</div>
					
					<br/>
					
					<center>
						<select name="ocupacion"><option value ="1">Ingeniero</option><option value ="2">Medico</option><option value ="3">Empresario</option><option value ="4">Estudiante TIC</option><option value ="5">Estudiante Ciencias Sociales</option><option value ="6">Estudiante Ciencias Salud</option><option value ="7">Estudiante Letras</option></select></td></tr>
					</center>
					
					<br/>
		  
					<div class="field-wrap">
						<input type="password" name="password"required autocomplete="off" placeholder="ContraseÃ±a"/>
					</div>
					
					
					<div class="field-wrap">
						<input type="password"  name= "password2" required autocomplete="off" placeholder="Confirma contraseÃ±a"/>
					</div>
          
					<div class="boton">
						<input type="submit" id="registro" name="Contestar"  >
					</div>
				</form>

			</div>
		
		</div>
	</body>
</html>