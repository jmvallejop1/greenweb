package com.greenweb.noticia;

import java.util.List;

import com.greenweb.comentario.dao.ComentarioDAO;
import com.greenweb.comentario.data.ComentarioDO;
import com.greenweb.noticia.dao.NoticiaDAO;
import com.greenweb.noticia.data.NoticiaDO;
import com.greenweb.usuario.dao.UsuarioDAO;
import com.greenweb.usuario.data.UsuarioDO;


public class NoticiaManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NoticiaManager usu = new NoticiaManager();
		
		NoticiaDAO c1Dao = new NoticiaDAO();
		
		NoticiaDO c1 = new NoticiaDO();
		NoticiaDO c2 = new NoticiaDO();
		
		// Creamos un comentario
		
		mostrarNoticias();
		
		c1.setId(150);
		c1.setTitulo("Menuda noticia");
		c1.setTexto("Atentado en la casa blanca");
		c1.setVideo("vide.mp4");
	
		
		
		// Añdimos noticia c1 creado antes
		añadirUnaNoticia(c1);
		
		// Mostrar noticias
		mostrarNoticias();
		
		// BorrarNoticias
		eliminarUnaNoticia(c1);
		
		
		mostrarNoticias();
		
		
		/*
		añadirUnComentario(c1);
		
		System.out.println(" ------------ AÑADIR COMENTARIO ---------\n\n");
		
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
	public static List<NoticiaDO> mostrarNoticias()
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
	
	// añadimos un comentario a la lista OK
	public static void añadirUnaNoticia(NoticiaDO c) {
		NoticiaDAO dao = new NoticiaDAO();
		try {
			dao.añadirNoticia(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// añadimos un comentario a la lista OK
	public static void eliminarUnaNoticia(NoticiaDO c) {
		NoticiaDAO dao = new NoticiaDAO();
		try {
			dao.eliminarNoticia(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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