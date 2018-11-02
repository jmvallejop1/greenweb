<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.greenweb.usuario.*,java.util.List,com.greenweb.usuario.data.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
UsuarioManager man=new UsuarioManager();
List<UsuarioDO> result=man.obtenerTodosUsuarios();
for(int i=0;i<result.size();i++)
{
	out.println(result.get(i).getLogin());
%>

 

<%} %>

</body>
</html>