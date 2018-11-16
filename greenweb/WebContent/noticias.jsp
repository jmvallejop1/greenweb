<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*"
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Noticias</title>
    <!-- import the webpage's stylesheet -->
    <link rel="stylesheet" href="css/noticias.css">
     <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    
  </head>  
  <body>
  
<%@include file="menu.jsp"%>

  <SECTION>
  
<%
	NoticiaManager m = new NoticiaManager();
  	List<NoticiaDO> li= m.mostrarNoticias();

%>

<%for(int i = 0;i<5;i++){ %>
    <div class="NoticeContainer"> 
        <div id="<%out.println(li.get(i).getTitulo());%>">     
	      <div class="NoticeHeader">           
	          <h3><a href="reto.html"><%out.println(li.get(i).getTitulo()); %></a></h3>
	          <h4 class="IrPreg"> <a href="reto.html">Ir a reto</a></h4>
	      </div>
	      <div class="InfoNoticia">
	          <p><video  controls="controls">
	          <source src="video/vid1.mp4" type="video/mp4">
	          </video>  <%out.println(li.get(i).getTexto()); %> 
	          </p>
	       </div>
	    </div>       
    </div> 
  	<%} %> 
    </SECTION>


<iframe src="footer.html" class="frames2" scrolling="no" border="no" width="100%" height="90" frameborder="no"></iframe>


  </body>
</html>