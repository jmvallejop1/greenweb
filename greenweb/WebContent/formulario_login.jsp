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
	</head>
	
	<body>
        <div class="loginBox">   
			<form action="alu/index_alu.jsp" method="post">
			
			  <h1>Iniciar Sesion</h1>
          
				<div class="field-wrap">
					<input type="email"required autocomplete="off" placeholder="Nombre de ususario" name="user"/>
				</div>
          
				<div class="field-wrap">
					<input type="password"required autocomplete="off" placeholder="ContraeÃ±a" name="pass"/>
				</div>
          
				<p class="forgot"><a href="#">Â¿Olvidaste tu contraseÃ±a?</a></p>
          
				<button class="button button-block"/>Iniciar Sesion</button>
          
          </form>

        </div>
	</body>
</html>