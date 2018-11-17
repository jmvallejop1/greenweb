<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
import="com.greenweb.noticia.*,java.util.List,com.greenweb.noticia.data.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	session = request.getSession(false);
	int hasta = 0;
	if(session!=null) {
		 hasta =  (int)session.getAttribute("hasta");
	}
	hasta+=5;
	//int tipo = Integer.parseInt(request.getParameter("num"));
		NoticiaManager m = new NoticiaManager();
  		List<NoticiaDO> li= m.mostrarNoticias();
		if(li.size()<10){
			hasta  = li.size();
		}
		
		for(int i = 0;i<hasta;i++){ %>

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

	  	<%}  session.setAttribute("hasta",hasta);%>

	  	</table>	
</body>
</html>