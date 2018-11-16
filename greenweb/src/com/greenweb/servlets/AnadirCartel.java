package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

@WebServlet("/AnadirCartel")
public class AnadirCartel extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Definitavente hay que eliminar los strings y sustituirlos directamente en lso setters
		System.out.println("Registrando");
		String usr = request.getParameter("usuario");
		String username = request.getParameter("username");
		String mail = request.getParameter("correo");
		int est = Integer.parseInt(request.getParameter("ocupacion"));
		int edad = Integer.parseInt(request.getParameter("edad"));
		String pass = request.getParameter("password");
		String	pass2 = request.getParameter("password2");
		System.out.println("Nombre: "+ usr + " Correo: "+ mail+" Estudios: "+ est);
		System.out.println("edad: "+ edad + " p1: "+ pass+" p2: "+ pass2);
		
		UsuarioManager um = new UsuarioManager();
		//Comprbar que el nimbre de usario no existe en la base de datos
		//TODO hacer la funcion de añadir
		if(!um.existeUsuario(username)) {
			if(usr != null) {
					if(pass != null) {
						if(pass.equals(pass2)) {
							UsuarioDO us = new UsuarioDO();
							us.setNombre(usr);
							us.setUsername(username);
							us.setMail(mail);
							us.setContr(pass);
							us.setEdad(edad);
							us.setEstudios(est);
							us.setPuntos(0);
							us.setTipo("u");
							
							
							if(um.anadirUsuario(us)==1)
								response.sendRedirect(request.getContextPath()+"/formulario_login.jsp?param=log");
							else
								response.sendRedirect(request.getContextPath()+"/formulario_reg.jsp?error=nlo");
						}else {		
							response.sendRedirect(request.getContextPath()+"/formulario_reg.jsp?error=wpw");
						}
					}else {
						response.sendRedirect(request.getContextPath()+"/formulario_reg.jsp?error=npw");
					}
			}else {
				response.sendRedirect(request.getContextPath()+"/formulario_reg.jsp?error=une");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/formulario_reg.jsp?error=uex");
		}
	}

}

