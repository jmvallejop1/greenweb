<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*"
import="com.greenweb.cartel.*,java.util.List,com.greenweb.cartel.data.*"
import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*"
import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"
%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
	<link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet"> 
    <link rel="stylesheet" href="css/reto.css">
    <title>Reto</title>
  </head>
  <body>
  	<section>

  	<jsp:useBean id="pre" class="com.greenweb.cartel.CartelesManager"/>
  	<jsp:setProperty name="pre" property="idn" value="${sessionScope.idnot}" /> 
    <div class="container">
	    <div class=noticia">
	        <h1><c:out value="${pre.noticia.noti.titulo}"></c:out></h1>
	            <p><video  controls="controls">
	              <source src="<c:out value="${pre.noticia.noti.video}"></c:out>" type="video/mp4">
	            </video><c:out value="${pre.noticia.noti.texto}"></c:out>
	            </p>
	     </div>       
	     <div class="pregunta2">
	          <h3><c:out value="${pre.noticia.preg.preg}"></c:out></h3>
	          <form>
	          <ul>
	              <li><input type="checkbox" name="resp" value="1" />
	              <label><c:out value="${pre.noticia.preg.r1}"></c:out></label></li>
	              <li><input type="checkbox" name="resp" value="2" />
	              <label><c:out value="${pre.noticia.preg.r2}"></c:out></label></li>
	              <li><input type="checkbox" name="resp" value="3" />
	              <label><c:out value="${pre.noticia.preg.r3}"></c:out></label></li>
	              <li><input type="checkbox" name="resp" value="4" />
	              <label><c:out value="${pre.noticia.preg.r4}"></c:out></label></li>
	          </ul>
	          <input type="button" name="Cancelar" value="Confirmar" >
	          </form>
	      </div>
    </div> 

  </section>	
  </body>
</html>

