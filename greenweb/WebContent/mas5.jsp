<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
import="com.greenweb.enlace.*,java.util.List,com.greenweb.enlace.data.*"
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
		EnlacesManager man=new EnlacesManager();
		List<EnlaceDO> todos=man.obtenerTodosEnlaces();
		if(todos.size()<10){
			hasta  = todos.size();
		}
		
	%>
	
	<table id="tabla">
			<thead>
				<tr><th>Enlaces mejor valorados</th><th>Votos verdes</th></tr>
			</thead>
	
	<% 			
			for(int i=0;i<hasta;i++){
	%>
			<tr><td><% out.println(todos.get(i).getURL()); %></td> <td class="prueba"><% out.println(todos.get(i).getVotos()); %></td></tr>
				
	<%		} session.setAttribute("hasta",hasta);%>

	  	</table>	
</body>
</html>