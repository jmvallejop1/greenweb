<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Noticias</title>
    <!-- import the webpage's stylesheet -->
    <link rel="stylesheet" href="css/noticias.css">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
	$(document).ready(function() {
		$('#mostrar').click(function(event) {
			$.post('mas5/mas5noticias.jsp', {
			}, function(responseText) {
				$('#not').html(responseText);
			});
		});
	});
	</script>
  </head>  
<body>  
<%@include file="menu.jsp"%>
	<jsp:useBean id="man" class="com.greenweb.noticia.NoticiaManager"/>
	<div id="not">
		<c:if test = "${sessionScope.hasta > fn:length(man.noticias)}">
			<c:set var = "hasta" scope = "session" value = "${fn:length(man.noticias)}"/>
		</c:if>
		<c:forEach var="noticia" end="3" items="${man.noticias}">
		<div class="NoticeContainer"> 
			<div id="<c:out value="${noticia.id}"></c:out>">     
				<div class="NoticeHeader">           
					<h3><a href="reto.html"><c:out value="${noticia.titulo}"></c:out></a></h3>
					<h4 class="IrPreg"> <a href="reto.html">Ir a reto</a></h4>
				</div>
				<div class="InfoNoticia">
					<p><video  controls="controls">
					<source src="video/vid1.mp4" type="video/mp4">
					</video><c:out value="${noticia.texto}"></c:out> 
					</p>
				</div>
			</div>       
		</div> 
		</c:forEach>
	</div>
	<input type="button" id="mostrar" value="Mostrar Noticias" /> 
<iframe src="footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>


  </body>
</html>