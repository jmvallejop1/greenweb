package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.usuario.UsuarioManager;

@WebServlet("/Baja")
public class Baja extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			UsuarioManager um = new UsuarioManager();
			String id = (String)session.getAttribute("id");
			if(um.eliminarUsuario(id)) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}		
	}
}
