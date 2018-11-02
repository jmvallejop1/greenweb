package com.greenweb.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class Filtro_prof implements Filter{
	
public void init(FilterConfig f) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("doFilter");
		// TODO Auto-generated method stub
		HttpServletRequest request= (HttpServletRequest)arg0;
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			if(session.getAttribute("logged")!= null) {
				if(session.getAttribute("logged")=="prof")
					arg2.doFilter(arg0, arg1);
				else
					((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=acceserror");
			}				
			else {
				String usr = arg0.getParameter("user");
				String pass = arg0.getParameter("pass");	
				
				if(usr == null || pass == null) {
					 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=loginerror");
					 
				}else {
					//TODO comprobar usuario y contraseña. si ok añadir logged a session, sino sendRedirect 
					session.setAttribute("logged","prof");
					arg2.doFilter(arg0, arg1);
				}
			}
		}
		else
		{
			 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp");
			
		}
		
	}


}
