<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ranking</title>
<link rel="stylesheet" href="css/ranking.css">
<script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
</head>



<body>

<%
UsuarioManager man=new UsuarioManager();
List<UsuarioDO> result=man.obtenerTodosUsuarios();
%>

	<iframe src="menu_global.html" class="frames" scrolling="no"
		border="no" width="100%" height="220" frameborder="no"></iframe>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Posicion</th>
					<th>Usuario</th>
					<th>Puntuacion</th>
				</tr>
			</thead>
			
			<%//for(int i=0;i<result.size();i++)
			
			//{%>

			<tr>
				<td>1
				</th>
				<td><%//out.println(result.get(i).getNombre());%></td>
				<td>34</td>
			</tr>
			
			<%//} %>
		</table>
	</div>
</body>

<iframe src="footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>

</html>