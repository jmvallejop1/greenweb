

    <%
    if(session.getAttribute("logged")!=null)
    {
		String tipoUsuario=(String)session.getAttribute("logged");
		if(tipoUsuario=="alu")
		{%>   
			<iframe src="alu/menu_alu.jsp" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
		<%}
    }
    else
    {%>   
	<iframe src="menu_global.html" class="frames" scrolling="no" border="no" width="100%" height="220" frameborder="no"></iframe>
	<%}

	%>
