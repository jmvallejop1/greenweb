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

@WebServlet("/ContestarInvitado")
public class ContestarInvitado extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		if(session!=null) {
			 String[] respuestas = request.getParameterValues("resp[]");
			 int re = 0;
			 for(int i =0;i<respuestas.length;i++) {
				 re = (re*10) + Integer.parseInt(respuestas[i]);
			 }
			 PreguntasManager m = new PreguntasManager();
			 boolean b = m.responderInvitadoRA(re);
			 if(b){
				 out.println("1");
			 }else {
				 out.println("0");
			 }
		}
	}
}