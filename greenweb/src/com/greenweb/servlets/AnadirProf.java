package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenweb.usuario.UsuarioManager;

@WebServlet("/AnadirProf")
public class AnadirProf extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioManager m = new UsuarioManager();
		String usuario = request.getParameter("prof");
		if(m.existeUsuario(usuario)) {
			System.out.println("El usuario exisite");
			response.sendRedirect(request.getContextPath()+"/prof/gesPro.jsp?param=alu");
		}else {
			System.out.println("El usuario no exisite");
			response.sendRedirect(request.getContextPath()+"/prof/gesPro.jsp?param=nou");	
		}
	}
}
