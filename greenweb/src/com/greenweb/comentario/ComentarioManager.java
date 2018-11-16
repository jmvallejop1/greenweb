package com.greenweb.comentario;

import java.util.List;

import com.greenweb.comentario.dao.ComentarioDAO;
import com.greenweb.comentario.data.ComentarioDO;
import com.greenweb.usuario.dao.UsuarioDAO;
import com.greenweb.usuario.data.UsuarioDO;


public class ComentarioManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ComentarioManager usu = new ComentarioManager();
		
		ComentarioDAO c1Dao = new ComentarioDAO();
		
		ComentarioDO c1 = new ComentarioDO();
		ComentarioDO c2 = new ComentarioDO();
		
		// Creamos un comentario
		
		//mostrarComentarios();
		
		c1.setIdUser("alfon");
		c1.setComentario("Que mierda");
		c1.setFecha("02/02/2005");
		
		c2.setIdUser("alu5");
		
		
		// Añdimos comentario c1 creado antes
		//añadirUnComentario(c1);
		
		// borramos comentario
		
		//añadirUnComentario(c1);
		
		System.out.println(" ------------ AÑADIR COMENTARIO ---------\n\n");
		
		//mostrarComentarios();
		
		//borrarUnComentario(c1);
		
		System.out.println(" ------------ BORRAR COMENTARIO ALFON ---------\n\n");
		
		//mostrarComentarios();
		
		System.out.println(" ------------ BORRAR COMENTARIO PEPE ---------\n\n");
		
		//borrarUnComentario(c2);
		
		//mostrarComentarios();
		
		
		//int total = contarComentarios();
		//System.out.println("El total de comentarios es --> " + total);
	}
	
	
	// publicamos los comentarios de los usuarios OK
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
	
	// añadimos un comentario a la lista OK
	public void añadirUnComentario(ComentarioDO c) {
		ComentarioDAO dao = new ComentarioDAO();
		try {
			dao.añadirComentario(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// añadimos un comentario a la lista OK
	public void borrarUnComentario(ComentarioDO c) {
		ComentarioDAO dao = new ComentarioDAO();
		try {
			dao.eliminarComentario(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// contar comentarios OK
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
