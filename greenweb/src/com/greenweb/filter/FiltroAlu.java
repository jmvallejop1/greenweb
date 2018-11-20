package com.greenweb.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.greenweb.hashfunct.FuncionHash;
import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

public class FiltroAlu implements Filter{
	
public void init(FilterConfig f) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("filtroAlu");
		// TODO Auto-generated method stub
		HttpServletRequest request= (HttpServletRequest)arg0;
		HttpSession session = request.getSession(false);
		if(session!=null)
		{		
			if(session.getAttribute("logged")!= null) {
				if(session.getAttribute("logged")=="alu")
					arg2.doFilter(arg0, arg1);
				else
					((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=acceserror");
			}else {
				((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=acceserror");
			}
		}else
		{
			 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp");
			
		}
		
	}


}
