package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.entrega.EntregaManager;

@WebServlet("/AsociarUserEntrega")
public class AsociarUserEntrega extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		if(session!=null) {
			EntregaManager m = new EntregaManager();
			String fecha = request.getParameter("fecha");
			String username =  (String)session.getAttribute("id");
			int turnoE=m.numEntrega(fecha);
			if(m.asignarEntrega(username, turnoE)) out.println(0);
			else out.println(-1);
		}
	}
}