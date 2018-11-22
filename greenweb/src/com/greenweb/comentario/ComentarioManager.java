package com.greenweb.comentario;

import java.util.List;

import com.greenweb.comentario.dao.ComentarioDAO;
import com.greenweb.comentario.data.ComentarioDO;


public class ComentarioManager {

	public static void main(String[] args) throws Exception {
		/*ComentarioManager usu = new ComentarioManager();
		
		ComentarioDAO c1Dao = new ComentarioDAO();
		
		ComentarioDO c1 = new ComentarioDO();
		ComentarioDO c2 = new ComentarioDO();
		
		// Creamos un comentario
		
		//mostrarComentarios();
		
		c1.setIdUser("alfon");
		c1.setComentario("Que mierda");
		c1.setFecha("02/02/2005");
		
		c2.setIdUser("alu5");
		
		
		// A�dimos comentario c1 creado antes
		//a�adirUnComentario(c1);
		
		// borramos comentario
		
		//a�adirUnComentario(c1);
		
		System.out.println(" ------------ A�ADIR COMENTARIO ---------\n\n");
		
		//mostrarComentarios();
		
		//borrarUnComentario(c1);
		
		System.out.println(" ------------ BORRAR COMENTARIO ALFON ---------\n\n");
		
		//mostrarComentarios();
		
		System.out.println(" ------------ BORRAR COMENTARIO PEPE ---------\n\n");
		
		//borrarUnComentario(c2);
		
		//mostrarComentarios();
		
		
		//int total = contarComentarios();
		//System.out.println("El total de comentarios es --> " + total);*/
	}
	
	
	// devuelve una lista con los comentarios de todos los usuarios
	public List<ComentarioDO> mostrarComentarios()
	{
		
		ComentarioDAO dao=new ComentarioDAO();
		try {
			// Devolvemos una lista con los comentarios
			return dao.listarComentarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	
	}
	
	public List<ComentarioDO> getComentarios(){
		return this.mostrarComentarios();
	}
	
	// añadimos un comentario en la base de datos
	public void anyadirUnComentario(ComentarioDO c) {
		ComentarioDAO dao = new ComentarioDAO();
		try {
			dao.anyadirComentario(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// se borra un comentario de la base de datos
	public void borrarUnComentario(ComentarioDO c) {
		ComentarioDAO dao = new ComentarioDAO();
		try {
			dao.eliminarComentario(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// devuelve el numero de comentarios alojados en la base de datos
	public int contarComentarios(){
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
