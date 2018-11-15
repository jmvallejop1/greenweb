<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page
import="com.greenweb.servlets.*,java.util.List,com.greenweb.usuario.data.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ranking</title>
<link rel="stylesheet" href="css/ranking.css">
<script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			$.post('anade5', {
				num: 1
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
</script>
</head>


<body>

<%@include file="menu.jsp"%>
		<table id="tabla">
			<thead>
				<tr>
					<th>Posicion</th>
					<th>Usuario</th>
					<th>Puntuacion</th>
				</tr>
			</thead>
			
			<tr>
				<td>1</td>
				<td>34</td>
			</tr>	
		</table>
		<input type="button" id="submit" value="Mostrar Enlaces" /> 
</body>

<iframe src="footer.html" class="frames" scrolling="no" border="no"
	width="100%" height="130" frameborder="no"></iframe>

</html>