package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.enlace.EnlacesManager;
import com.greenweb.usuario.UsuarioManager;

@WebServlet("/CambiarDatos")
public class CambiarDatos extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioManager m = new UsuarioManager();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String id = (String)session.getAttribute("id");
			int age = 0;
			int est = 0;
			String mail = request.getParameter("email");
			String ageaux = request.getParameter("age");
			if(ageaux != null && ageaux != "")
				age = Integer.parseInt(request.getParameter("age"));
			String estaux = request.getParameter("ocupacion");
			if(estaux != null && estaux != "")
				 est = Integer.parseInt(request.getParameter("ocupacion"));
			
				m.actualizarUsuario(id, mail, age, est);			
				String log = (String)session.getAttribute("logged");
				if(log.equals("alu"))
					response.sendRedirect(request.getContextPath()+"/alu/profile.jsp");
				else if(log.equals("prof"))
					response.sendRedirect(request.getContextPath()+"/prof/profile.jsp");
				else
					response.sendRedirect(request.getContextPath()+"/privada/profile.jsp");
			
		}else {
			//Devuelves al perfil con el parametro nse no session
			String log = (String)session.getAttribute("logged");
			if(log.equals("alu"))
				response.sendRedirect(request.getContextPath()+"/alu/profile.jsp");
			else if(log.equals("prof"))
				response.sendRedirect(request.getContextPath()+"/prof/profile.jsp");
			else
				response.sendRedirect(request.getContextPath()+"/privada/profile.jsp");
		}
		
		
		
	}
}