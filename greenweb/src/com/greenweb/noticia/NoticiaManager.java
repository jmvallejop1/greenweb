package com.greenweb.noticia;

import java.util.List;

import com.greenweb.comentario.dao.ComentarioDAO;
import com.greenweb.noticia.dao.NoticiaDAO;
import com.greenweb.noticia.data.NoticiaDO;

public class NoticiaManager {

	public static void main(String[] args) throws Exception {
/*		NoticiaManager usu = new NoticiaManager();
		
		NoticiaDAO c1Dao = new NoticiaDAO();
		
		NoticiaDO c1 = new NoticiaDO();
		NoticiaDO c2 = new NoticiaDO();
		
		// Creamos un comentario
		
		
		c1.setId(150);
		c1.setTitulo("Menuda noticia");
		c1.setTexto("Atentado en la casa blanca");
		c1.setVideo("vide.mp4");
	
		
		
		// A�dimos noticia c1 creado antes
		//a�adirUnaNoticia(c1);
		
		// BorrarNoticias
		eliminarUnaNoticia(c1);
		
		
		
		
		/*
		a�adirUnComentario(c1);
		
		System.out.println(" ------------ A�ADIR COMENTARIO ---------\n\n");
		
		mostrarComentarios();
		
		borrarUnComentario(c1);
		
		System.out.println(" ------------ BORRAR COMENTARIO ALFON ---------\n\n");
		
		mostrarComentarios();
		
		System.out.println(" ------------ BORRAR COMENTARIO PEPE ---------\n\n");
		
		borrarUnComentario(c2);
		
		mostrarComentarios();
		
		
		int total = contarComentarios();
		System.out.println("El total de comentarios es --> " + total);
		*/
	}
	
	
	// publicamos los comentarios de los usuarios OK
	public List<NoticiaDO> mostrarNoticias()
	{	
		NoticiaDAO dao=new NoticiaDAO();
		try {
			// Devolvemos una lista con los comentarios
			return dao.listarNoticias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	
	}
	
	public List<NoticiaDO> getNoticias(){
		return this.mostrarNoticias();
	}
	
	// a�adimos un comentario a la lista OK
	public static void anadirUnaNoticia(NoticiaDO c) {
		NoticiaDAO dao = new NoticiaDAO();
		try {
			dao.anadirNoticia(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// a�adimos un comentario a la lista OK
	public static void eliminarUnaNoticia(NoticiaDO c) {
		NoticiaDAO dao = new NoticiaDAO();
		try {
			dao.eliminarNoticia(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public NoticiaDO crearN(String titulo, String texto, String video) {
		NoticiaDAO dao=new NoticiaDAO();
		try {
			return dao.crearNot(titulo, texto, video);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// contar comentarios OK
	public static int contarComentarios(){
		ComentarioDAO dao = new ComentarioDAO();
		try {
			int cuenta = dao.numComentarios();
			return cuenta;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}