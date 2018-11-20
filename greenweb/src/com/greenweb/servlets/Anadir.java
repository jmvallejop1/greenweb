package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

@WebServlet("/Anadir")
public class Anadir extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioManager m = new UsuarioManager();
		String usuario = request.getParameter("usuario");
		int cambio = Integer.parseInt(request.getParameter("tipo"));
		String tipo = "";
		if(cambio==1){
			tipo = "p";
		}else if(cambio==2) {
			tipo = "a";
		}else if(cambio==3) {
			tipo = "u";
			usuario = usuario.substring(0, usuario.length()-1);			
		}
		if(m.existeUsuario(usuario)) {
			System.out.println("El usuario exisite");
			UsuarioDO u = m.obtenerUsuario(usuario);
			m.cambiarTipoUsuario(u, tipo);
			m.obtenerUsuario(usuario);
			response.sendRedirect(request.getContextPath()+"/prof/gesAlu.jsp?param=alu");
		}else {
			System.out.println("El usuario no exisite");
			response.sendRedirect(request.getContextPath()+"/prof/gesAlu.jsp?param=nou");
		}
		
	}
}