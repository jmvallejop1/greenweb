package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.pregunta.PreguntasManager;

@WebServlet("/ContestarActual")
public class ContestarActual extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		if(session!=null) {
			 //String idUser =  (String)session.getAttribute("id");
			 String idUser = "6k";
			 String[] respuestas = request.getParameterValues("resp[]");
			 int re = 0;
			 for(int i =0;i<respuestas.length;i++) {
				 re = (re*10) + Integer.parseInt(respuestas[i]);
			 }
			 PreguntasManager m = new PreguntasManager();
			 if(m.responderPreguntaRA(idUser, re)){
				 out.println("1");
			 }else {
				 out.println("0");
			 }			 			  
		}
	}
}