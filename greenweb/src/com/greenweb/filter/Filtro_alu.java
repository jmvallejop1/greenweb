package com.greenweb.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

public class Filtro_alu implements Filter{
	
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
				if(session.getAttribute("logged")=="alu")
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
					// comprobar tambien que tipo se usuario es y añadirle el logged dependiendo
					UsuarioManager m = new UsuarioManager();
					UsuarioDO u = m.obtenerUsuario(usr);
					if(u.getContr().equals(pass)) {
						if(u.getTipo().equals("u")) {
							session.setAttribute("logged","normal");
							((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/privada/index_priv.jsp");
						}else if(u.getTipo().equals("a")) {
							session.setAttribute("logged","alu");
							((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/alu/index_alu.jsp");
						}else if(u.getTipo().equals("p")) {
							((HttpServletResponse)arg1).sendRedirect(request.getContextPath()+"/prof/index_prof.jsp");
							session.setAttribute("logged","prof");
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
