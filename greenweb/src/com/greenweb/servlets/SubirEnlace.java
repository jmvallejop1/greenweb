package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.enlace.EnlacesManager;

@WebServlet("/SubirEnlace")
public class SubirEnlace extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnlacesManager m = new EnlacesManager();
		String id= request.getParameter("id");
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String user = (String)session.getAttribute("id");
			m.subirEnlace(id,user);
		}
		System.out.println(id);
		
		
		
	}
}