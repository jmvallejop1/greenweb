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
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "images";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Definitavente hay que eliminar los strings y sustituirlos directamente en lso setters
		/*System.out.println("Subiendo archivos");
		String texto = request.getParameter("texto");
		String vid = request.getParameter("video");
		Part p1 = request.getPart("video");
        InputStream is = (InputStream) p1.getInputStream();
		String img = request.getParameter("imagenes");
		String preg = request.getParameter("pregunta");
		String r1 = request.getParameter("respuesta_uno");
		String r2 = request.getParameter("respuesta_dos");
		String r3 = request.getParameter("respuesta_tres");
		String r4 = request.getParameter("respuesta_cuatro");
		String correcta = request.getParameter("respuesta_correcta");*/
		
		/*Part filePart = request.getPart("imagen"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();*/
		String applicationPath = getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;

		File fileSaveDir = new File(uploadPath);		
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fileName = "";
        for (Part part : request.getParts()) {
        	fileName = "/espi.jpg";
        	try {
        		part.write(uploadPath + File.separator + fileName);
        	 } catch (IOException ioObj) {
        		 System.out.println("excepcion");
        	 }
        	
        }
		/*OutputStream img = null;
		InputStream filecontent = null;
		Part foto = request.getPart("imagen");
		File fi = new File(uploadPath + "/ESPI.jpg");
		fi.createNewFile();
		img = new FileOutputStream(fi);
		filecontent = foto.getInputStream();
		int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = filecontent.read(bytes)) != -1) {
            img.write(bytes, 0, read);
        }*/
        
		//Comprbar que el nimbre de usario no existe en la base de datos
		//TODO hacer la funcion de añadir
        System.out.println("hola");
	}
	

	

}

