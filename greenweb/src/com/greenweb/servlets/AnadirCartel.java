package com.greenweb.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.InputStream;
import java.io.OutputStream;

import com.greenweb.usuario.UsuarioManager;
import com.greenweb.usuario.data.UsuarioDO;

@WebServlet("/AnadirCartel")
@MultipartConfig
public class AnadirCartel extends HttpServlet{

	/**
	 * 
	 */
	private String rutaBase = "C:\\Users\\Jmval\\Desktop\\apache-tomcat-9.0.12\\webapps\\";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part foto = request.getPart("foto");
		OutputStream img = null;
		InputStream filecontent = null;
		
		File fi = new File(rutaBase + "pepe.jpg");
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
	}
	

	

}

