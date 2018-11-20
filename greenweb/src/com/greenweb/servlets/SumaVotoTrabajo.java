package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenweb.cartel.CartelesManager;

@WebServlet("/SumaVotoTrabajo")
public class SumaVotoTrabajo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartelesManager m = new CartelesManager();
		//OBTENER CARTEL QUE HA PULSADO
		int id= Integer.parseInt(request.getParameter("idcartel"));
		System.out.println(id);
		m.sumarVoto(id);		
	}
}
