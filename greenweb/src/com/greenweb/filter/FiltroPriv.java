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
		System.out.println("doFilter");
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
			}	
			else {
				String usr = arg0.getParameter("user");
				String pass = arg0.getParameter("pass");	
				
				if(usr == null || pass == null) {
					 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=loginerror");
					 
				}else {
					//TODO comprobar usuario y contrase�a. si ok a�adir logged a session, sino sendRedirect 
					UsuarioManager m = new UsuarioManager();
					UsuarioDO u = m.obtenerUsuario(usr);
					if(u.getContr().equals(pass)) {
						if(u.getTipo().equals("u")) {
							session.setAttribute("logged","normal");
							session.setAttribute("id",usr);
						}else if(u.getTipo().equals("a")) {
							session.setAttribute("logged","alu");
							session.setAttribute("id",usr);
						}else if(u.getTipo().equals("p")) {
							session.setAttribute("logged","prof");
							session.setAttribute("id",usr);
						}
					
					arg2.doFilter(arg0, arg1);
					}else {
						((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=wpw");
					}
				}
			}
		}
		else
		{
			 ((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/formulario_login.jsp");
			
		}
		
	}

}