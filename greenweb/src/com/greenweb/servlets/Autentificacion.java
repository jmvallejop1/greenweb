package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.hashfunct.FuncionHash;
import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

@WebServlet("/Autentificacion")
public class Autentificacion extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("autentificando");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String usr = request.getParameter("user");
			String pass = request.getParameter("pass");
			if(usr == null || pass == null) {
				 response.sendRedirect(request.getContextPath()+"/formulario_login.jsp?error=loginerror");				 
			}
			UsuarioManager m = new UsuarioManager();
			UsuarioDO u = m.obtenerUsuario(usr);
			if(u.getContr().equals(FuncionHash.md5Hash(pass))) {
				String tipo = u.getTipo();
				if(tipo.equals("u")) {
					session.setAttribute("logged","normal");
					session.setAttribute("id",usr);
					response.sendRedirect(request.getContextPath()+"/privada/index_priv.jsp");
				}else if(tipo.equals("a")) {
					session.setAttribute("logged","alu");
					session.setAttribute("id",usr);
					response.sendRedirect(request.getContextPath()+"/alu/index_alu.jsp");
				}else if(tipo.equals("p")) {
					session.setAttribute("logged","prof");
					session.setAttribute("id",usr);
					response.sendRedirect(request.getContextPath()+"/prof/index_prof.jsp");
				}			
			}else {
				response.sendRedirect(request.getContextPath()+"/prof/index_prof.jsp");
			}
		
		}
	}
}
