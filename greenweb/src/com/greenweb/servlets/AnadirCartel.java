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
import java.util.Calendar;
import java.util.Collection;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.greenweb.cartel.CartelesManager;
import com.greenweb.cartel.data.CartelDO;
import com.greenweb.entrega.EntregaManager;
import com.greenweb.noticia.NoticiaManager;
import com.greenweb.noticia.data.NoticiaDO;
import com.greenweb.pregunta.PreguntasManager;
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
		
		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/"); 
		
		Part foto = request.getPart("foto");
		OutputStream img = null;
		InputStream filecontent = null;

		String nom = foto.getHeader("content-disposition");
		String fileName = nom.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
		String delims = "[\\\\]";
		String[] tokens = fileName.split(delims);
		int total = tokens.length;
		fileName = tokens[total -1];
		
		

		File fi = new File(path +"/imgret/" +fileName);
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
        
        Part foto2 = request.getPart("video");
		OutputStream img2 = null;
		InputStream filecontent2 = null;
		
		nom = foto2.getHeader("content-disposition");
		String fileName2 = nom.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
		tokens = fileName2.split(delims);
		total = tokens.length;
		fileName2 = tokens[total -1];
		
		File fi2 = new File(path+"/vidret/"+fileName2);
		fi2.createNewFile();
		img2 = new FileOutputStream(fi2);
		filecontent2 = foto2.getInputStream();
		int read2 = 0;
        final byte[] bytes2 = new byte[1024];
        while ((read2 = filecontent2.read(bytes2)) != -1) {
            img2.write(bytes2, 0, read2);
        }
        img2.close();
        filecontent2.close();
        String[] alumno=new String[5];
        for(int i=0; i<5; i++) {
        	alumno[i]=request.getParameter("autor"+i);
        }
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		String pregunta = request.getParameter("pregunta");
		String r1 = request.getParameter("respuesta_uno");
		String r2 = request.getParameter("respuesta_dos");
		String r3 = request.getParameter("respuesta_tres");
		String r4 = request.getParameter("respuesta_cuatro");
		String rc = request.getParameter("respuesta_correcta");
		Calendar cal=Calendar.getInstance();
		String dia = Integer.toString(cal.get(Calendar.DATE));
		String mes = Integer.toString(cal.get(Calendar.MONTH)+1);
		String annio = Integer.toString(cal.get(Calendar.YEAR));
		String fecha = dia+"/"+mes+"/"+annio;
		
		if(titulo != null && !titulo.equals("") && texto != null && !texto.equals("") && pregunta != null && !pregunta.equals("")
		&& r1 != null && !r1.equals("") && r2 != null && !r2.equals("") && r3 != null && !r3.equals("") &&
		r4 != null && !r4.equals("") && rc != null && !rc.equals("") && alumno[0] != null && !alumno[0].equals("")) {
			PreguntasManager pman=new PreguntasManager();
			NoticiaManager nman=new NoticiaManager();
			CartelesManager cman=new CartelesManager();
			EntregaManager eman=new EntregaManager();
			PreguntaDO p = pman.crearP(pregunta, r1, r2, r3, r4, Integer.parseInt(rc));
			NoticiaDO n = nman.crearN(titulo, texto, "vidret/"+fileName2); //PONER VARIABLE VIDEO CON NOMBRE DEL VIDEO
			CartelDO c=cman.crearCartel(p, n, alumno,"imgret/"+fileName, fecha); //PONER VARIABLE FOTO CON NOMBRE DE FOTO
			if(eman.subirEntrega(alumno[0], c)) {
				out.println(0);
				response.sendRedirect(request.getContextPath()+"/alu/trabajos.jsp");
			}
			else {
				out.println(-1);
				response.sendRedirect(request.getContextPath()+"/alu/trabajos.jsp?error=not");
				
			}
		}else {
		response.sendRedirect(request.getContextPath()+"/alu/trabajos.jsp?error=not");
		}
		
		
	}
	

	

}

