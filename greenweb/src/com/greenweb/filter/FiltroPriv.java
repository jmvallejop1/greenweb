package com.greenweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

public class FiltroPriv implements Filter{
	
	public void init(FilterConfig f) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("filtroProf");
		// TODO Auto-generated method stub
		HttpServletRequest request= (HttpServletRequest)arg0;
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			if(session.getAttribute("logged")!= null) {
				if(session.getAttribute("logged")=="normal")
					arg2.doFilter(arg0, arg1);
				else
					((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=acceserror");
			}else {
				((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=acceserror");
			}
		}
		else
		{
			 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp");
			
		}
		
	}

}
