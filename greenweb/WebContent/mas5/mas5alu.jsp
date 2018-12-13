<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="com.greenweb.enlace.*,java.util.List,com.greenweb.enlace.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	var vot;
		$(document).ready(function() {
			$(".vota").click(function(){
				var miVar =  $(this).prev().prev().text();
				vot = $(this).prev();
		
				$.post("../SumaVoto", {
					id: miVar
				}, function(data) {
					$(vot).text(data);
				});
		    });
		});	
	</script>
</head>
<body>
	<jsp:useBean id="man" class="com.greenweb.enlace.EnlacesManager"/>
	<c:if test = "${sessionScope.hasta > fn:length(man.enlaces)}">
		<c:set var = "hasta" scope = "session" value = "${fn:length(man.enlaces)}"/>
	</c:if>      		
	<table id="tabla">
		<thead>
			<tr><th>Enlaces mejor valorados</th><th>Votos verdes</th><th>Vota</th></tr>
		</thead>
		<c:forEach var="enlace" end="${sessionScope.hasta}" items="${man.enlaces}">
			<tr><td><c:out value="${enlace.URL}"></c:out></td><td class="prueba"><c:out value="${enlace.votos}"></c:out></td><td class="vota"><img src="../images/fiable.png"></td></tr>		
		</c:forEach>
	</table>	
</body>
</html>