package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenweb.enlace.EnlacesManager;

@WebServlet("/SumaVoto")
public class SumaVoto extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EnlacesManager m = new EnlacesManager();
		String id= request.getParameter("id");
		System.out.println(id);
		out.println(m.aumentaVotos(id));
		
	}
}
