<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title> Pagina de comentarios </title>
		<link rel="stylesheet" href="../css/comentarios.css">
		<meta name="viewport" content="width=device-width, initial.scale=1">
		
		<link rel="stylesheet" href="css/font-awesome.-mi">
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'> 
	</head>
	<body>
			<div class="contenedor_comentarios">
				<h1> Foro de comentarios <a href="tal"></a></h1>
				<ul id="lista_comentarios" class="lista_comentarios">
					<li>
						<div class="comentario_principal">
							<div class="comentario_avatar">
								<img src="images/perfil.jpg" alt=""> 
							</div>
							<div class="comentario_caja">
								<div class="comentario_cabeza">
									<h6 class="nombre_comentario by-author"><a href="perfil.html"> Agustin Ortiz</a></h6> 
									<span> hace 5 minutos</span>
								</div>
								<div class="comentario_contenido">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo 
								</div>
							</div>
						</div>
					</li>	
					<li>
						<div class="comentario_principal">
							<div class="comentario_avatar">
								<img src="images/perfil.jpg" alt=""> 
							</div>
							<div class="comentario_caja">
								<div class="comentario_cabeza">
									<h6 class="nombre_comentario by-author"><a href="perfil.html"> Agustin Ortiz</a></h6> 
									<span> hace 7 minutos</span>
								</div>
								<div class="comentario_contenido">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo 
								</div>
							</div>
						</div>
					</li>
					
					<li>
						<div class="comentario_principal">
							<div class="comentario_avatar">
								<img src="images/perfil.jpg" alt=""> 
							</div>
							<div class="comentario_caja">
								<div class="comentario_cabeza">
									<h6 class="nombre_comentario by-author"><a href="perfil.html"> Leticia dominguez</a></h6> 
									<span> hace 10 minutos</span>
								</div>
								<div class="comentario_contenido">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo 
								</div>
							</div>
						</div>
					</li>
					
					<li>
						<div class="comentario_principal">
							<div class="comentario_avatar">
								<img src="images/perfil.jpg" alt=""> 
							</div>
							<div class="comentario_caja">
								<div class="comentario_cabeza">
									<h6 class="nombre_comentario by-author"><a href="perfil.html"> Andres Manguez</a></h6> 
									<span> hace 20 minutos</span>
								</div>
								<div class="comentario_contenido">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo 
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="pedir_comentario">
				<form action="../SubirComentario" method="post">
					<h3> Añade tu comentario y ayudanos a mejorar </h3>
					<textarea name="mejorar" id="mejorar"></textarea><br/>
					<input type="submit" name="EnviarComentario" value="Enviar Comentario"> 
				</form>
			</div>
			
	</body>
</html>