package com.greenweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenweb.entrega.EntregaManager;

@WebServlet("/SeleccionGanador")
public class SeleccionGanador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntregaManager man=new EntregaManager();
		//OBTENER CARTEL QUE HA PULSADO
		int idcart= Integer.parseInt(request.getParameter("idcartel"));
		System.out.println(idcart);
		man.NuevoReto(idcart);		
	}
}
