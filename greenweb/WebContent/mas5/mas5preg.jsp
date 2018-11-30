<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var cambio;
	$(document).ready(function(){
    	$(".bot").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    			$(this).prop('checked', false);
    		});
        	var id = $(this).parent().parent().parent().parent().attr("id");
        	cambio = $(this).parent().parent().parent().parent().parent();
        	$.ajax({
                type: "POST",
                url: 'Contestar',
                data: ({ idc: id , resp: array }),
                success: function(data) {
                    comprobar(data);    
                },
                error: function() {
                }
            });
        	
   	 });
	});
</script>
<script>
	function comprobar(valor){
		if(valor == -1){
			window.alert("No se puede mostrar respuesta porque pertenece al reto.");
		}else if(valor == 0){
			$(cambio).addClass("correcta");
		}else if(valor>0){	
			$(cambio).addClass("incorrecta");
			window.alert("Las respuestas correctas eran: " + valor);
		}
	}
</script>
<script>
	$(document).ready(function() {
		$('.fas').click(function(event) {
			var id = $(this).parent().parent().parent().attr("id");
			alert(id);
			$.ajax({
                type: "POST",
                url: 'RetoPreg',
                data: ({ idn: id}),
                success: function(data) {
                	alert("TodoOK");
                	window.open(data+"/retoP.jsp");   
                },
                error: function() {
                    alert('Error occured 23');
                }
            });
		});
	});
	</script>

</head>
<body>	
	<jsp:useBean id="man" class="com.greenweb.pregunta.PreguntasManager"/>
	<c:if test = "${sessionScope.hasta > fn:length(man.preguntas)}">
		<c:set var = "hasta" scope = "session" value = "${fn:length(man.preguntas)}"/>
	</c:if>
	<c:forEach var="pregunta" end="${sessionScope.hasta}" items="${man.preguntas}">
	<div>
		<div id="<c:out value="${pregunta.id}"></c:out>"> 
			<div class="PreguntaAdicional">
				<form>
					<h3><c:out value="${pregunta.preg}"></c:out></h3>
					<i class="fas fa-info-circle"></i>
					<div class="respuestas">
						<ul>
							<li><input type="checkbox" name="resp" value="1" />
							<label><c:out value="${pregunta.r1}"></c:out></label></li>
							<li><input type="checkbox" name="resp" value="2" />
							<label><c:out value="${pregunta.r2}"></c:out></label></li>
							<li><input type="checkbox" name="resp" value="3" />
							<label><c:out value="${pregunta.r3}"></c:out></label></li>
							<li><input type="checkbox" name="resp" value="4" />
							<label><c:out value="${pregunta.r4}"></c:out></label></li>
						</ul>
						<input type="button" class="bot" name="contestar" value="Contestar!">
					</div>
				</form>
			</div>
		</div>
	</div>
	</c:forEach>
</body>
</html>