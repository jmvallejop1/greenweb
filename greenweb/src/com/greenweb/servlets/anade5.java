package com.greenweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greenweb.enlace.EnlacesManager;
import com.greenweb.enlace.data.EnlaceDO;
import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;


//@WebServlet(urlPatterns = {"/enlaces.jsp", "/alu/enlaces_alu.jsp"})
@WebServlet("/anade5")
/*@WebServlet(
        name = "anade5",
        urlPatterns = {"anade5"}
)*/
public class anade5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<EnlaceDO> result;
	int hasta;
	
	public anade5() {
		super();
		EnlacesManager man=new EnlacesManager();
		result=man.obtenerTodosEnlaces();	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si lo queremos hacer a traves de un get, tenemos que poner el codigo del post en esta clase
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			 hasta =  (int)session.getAttribute("hasta");
		}
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		
		hasta++;
		
		// Compruebo que los campos del formulario tienen datos para añadir a la tabla
		
		// Obtengo los datos de la peticion
		out.println("<table id=\"tabla\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Posicion</th>");
		out.println("<th>Usuario</th>");
		out.println("<th>Puntuacion</th>");
		out.println("</tr>");
		out.println("</thead>");
		
		if(hasta>result.size()) {
			hasta = result.size();
		}
		
		for(int i=0;i<hasta;i++){
			String s = result.get(i).getURL();
			out.println("<tr>");
			out.println("<td>1</td>");
			out.println("<td>"+s+"</td>");
			out.println("<td>34</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		session.setAttribute("hasta",hasta);
		
		

	}
}