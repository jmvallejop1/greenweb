package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.pregunta.PreguntasManager;
import com.greenweb.usuario.UsuarioManager;

@WebServlet("/Contestar")
public class Contestar extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		if(session!=null) {
			 //String idUser =  (String)session.getAttribute("id");
			 String idUser = "pepe";
			 String idP = (String)request.getParameter("idc");
			 idP = idP.substring(0, idP.length()-1);
			 int idPreg = Integer.parseInt(idP);
			 //System.out.println("ID de l apregunta:"+idPreg);
			 String[] respuestas = request.getParameterValues("resp[]");
			 int re = 0;
			 for(int i =0;i<respuestas.length;i++) {
				 re = (re*10) + Integer.parseInt(respuestas[i]);
			 }
			 PreguntasManager m = new PreguntasManager();
			 int acierto = m.responderPreg(idUser, re, idPreg);
			 System.out.println("Responde acierto :"+ acierto);
			 out.println(acierto);
		}
		
		
		
	}
}