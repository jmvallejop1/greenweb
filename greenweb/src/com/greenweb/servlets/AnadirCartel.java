package com.greenweb.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.InputStream;
import java.io.OutputStream;

import com.greenweb.cartel.data.CartelDO;
import com.greenweb.noticia.data.NoticiaDO;
import com.greenweb.pregunta.data.PreguntaDO;
import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

@WebServlet("/AnadirCartel")
@MultipartConfig
public class AnadirCartel extends HttpServlet{

	/**
	 * 
	 */
	private String rutaBase = "C:\\Users\\Jose Maria Vallejo\\Desktop\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\greenweb\\";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part foto = request.getPart("video");
		OutputStream img = null;
		InputStream filecontent = null;
		
		File fi = new File(rutaBase +"pepe.mp4");
		fi.createNewFile();
		img = new FileOutputStream(fi);
		filecontent = foto.getInputStream();
		int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = filecontent.read(bytes)) != -1) {
            img.write(bytes, 0, read);
        }
        img.close();
        filecontent.close();
        
        /*Part foto2 = request.getPart("video");
		OutputStream img2 = null;
		InputStream filecontent2 = null;
		
		File fi2 = new File(rutaBase +"/juan.jpg");
		fi2.createNewFile();
		img2 = new FileOutputStream(fi2);
		filecontent2 = foto2.getInputStream();
		int read2 = 0;
        final byte[] bytes2 = new byte[1024];
        while ((read2 = filecontent.read(bytes2)) != -1) {
            img2.write(bytes2, 0, read2);
        }
        img2.close();
        filecontent2.close();*/
        
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		String pregunta = request.getParameter("pregunta");
		String r1 = request.getParameter("respuesta_uno");
		String r2 = request.getParameter("respuesta_dos");
		String r3 = request.getParameter("respuesta_tres");
		String r4 = request.getParameter("respuesta_cuatro");
		String rc = request.getParameter("respuesta_correcta");
		if(titulo!=null && !titulo.equals("") && texto!=null && !texto.equals("")&&pregunta!=null && !pregunta.equals("")
		&& r1!=null && !r1.equals("") && r2!=null && !r2.equals("") && r3!=null && !r3.equals("") &&
		r4!=null && !r4.equals("") && rc!=null && !rc.equals("")) {
			CartelDO d = new CartelDO();
			PreguntaDO p = new PreguntaDO();
			NoticiaDO n = new NoticiaDO();
			int rcor= Integer.parseInt(rc);
			p.setPreg(pregunta);
			p.setR1(r1);
			p.setR2(r2);
			p.setR3(r3);
			p.setR4(r4);
			p.setrOk(rcor);
			n.setTexto(texto);
			n.setTitulo(titulo);
		}
			
	
		
		
		
		//ServletContext context = request.getServletContext();
		//String path = context.getRealPath("/");
		
		
		
	}
	

	

}

