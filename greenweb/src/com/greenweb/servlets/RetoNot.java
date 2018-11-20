package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.enlace.EnlacesManager;

@WebServlet("/RetoNot")
public class RetoNot extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null) {
			String id= request.getParameter("idn");
			session.setAttribute("idnot",id);
			out.println(request.getContextPath());
		}
		
		
	}
}
