package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.usuario.UsuarioManager;

@WebServlet("/AnadirAlumno")
public class AnadirAlumno extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioManager m = new UsuarioManager();
		String usuario = request.getParameter("alumno");
		if(m.existeUsuario(usuario)) {
			System.out.println("El usuario exisite");
			response.sendRedirect(request.getContextPath()+"/prof/gesAlu.jsp?param=alu");
		}else {
			System.out.println("El usuario no exisite");
			response.sendRedirect(request.getContextPath()+"/prof/gesAlu.jsp?param=nou");
		}
		
	}
}