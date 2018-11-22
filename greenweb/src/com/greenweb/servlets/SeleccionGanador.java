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

@WebServlet("/SeleccionGanador")
public class SeleccionGanador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		if(session!=null) {
			EntregaManager man=new EntregaManager();
			//OBTENER CARTEL QUE HA PULSADO
			int idcart= Integer.parseInt(request.getParameter("idcartel"));
			if(man.NuevoReto(idcart)) {
				System.out.println("Holaaa");
				out.println(1);
			}
			else out.println(0);
		}
	}
}
