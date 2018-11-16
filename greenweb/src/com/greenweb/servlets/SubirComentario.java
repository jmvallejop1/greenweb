package com.greenweb.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.comentario.ComentarioManager;
import com.greenweb.comentario.data.ComentarioDO;
import com.greenweb.usuario.UsuarioManager;

@WebServlet("/SubirComentario")
public class SubirComentario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar c2 = Calendar.getInstance();
		String dia = Integer.toString(c2.get(Calendar.DATE));
		String mes = Integer.toString(c2.get(Calendar.MONTH + 1));
		String annio = Integer.toString(c2.get(Calendar.YEAR));
		String fecha = dia+"/"+mes+"/"+annio;
		HttpSession session = request.getSession(false);
		ComentarioManager m = new ComentarioManager();
		if(session!=null) {
			String id = (String)session.getAttribute("id");
			String comentario = request.getParameter("mejorar");
			ComentarioDO c1 = new ComentarioDO();
			if(!comentario.equals("")&&comentario != null) {
				c1.setComentario(comentario);
				c1.setIdUser(id);
				c1.setFecha(fecha);
				
				System.out.println("He escrito:"+ comentario);
			}
			m.añadirUnComentario(c1);
		
		System.out.println("He entrado en el servlet de los comentarios");
		response.sendRedirect(request.getContextPath()+"/alu/comentarios.jsp?param=ccm");
		}else {
			//Devuelves al perfil con el parametro nse no session
			response.sendRedirect(request.getContextPath()+"/alu/profile.jsp?param=nse");
		}
		
		
		
	}
}
