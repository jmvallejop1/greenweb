<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>

<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/login.css">
		<link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet"> 
		<title> Login </title>
		<html lang="es">
	</head>
	
	<body>
        <div class="loginBox">   
			<form action="Autentificacion" method="post">
			
			  <h1>Iniciar Sesion</h1>         
				<div class="field-wrap">
					<input id = "user" required autocomplete="off" placeholder="Nombre de ususario" name="user"/>
				</div>
          
				<div class="field-wrap">
					<input id = "passwd "type="password"required autocomplete="off" placeholder="Contraseña" name="pass"/>
				</div>
          
				
				<button type="submit" id="inicio">Iniciar Sesion</button>          
          </form>

        </div>
	</body>
</html>