<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="man" class="com.greenweb.noticia.NoticiaManager"/>
	<c:if test = "${sessionScope.hasta > fn:length(man.noticias)}">
		<c:set var = "hasta" scope = "session" value = "${fn:length(man.noticias)}"/>
	</c:if>
	<c:forEach var="noticia" end="${sessionScope.hasta}" items="${man.noticias}">
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
</body>
</html>