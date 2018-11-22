package com.greenweb.enlace;

import com.greenweb.enlace.dao.EnlaceDAO;
import com.greenweb.enlace.data.EnlaceDO;

import java.util.List;

public class EnlacesManager {
	
	public static void main(String[] args) {
/*		EnlacesManager usu = new EnlacesManager();
		usu.obtenerTodosEnlaces();
		usu.aumentaVotos("hola");*/
	}
	
	/*
	 * Devuleve una lista con todos los enlaces alojados en la BD
	 */
	public List<EnlaceDO> obtenerTodosEnlaces()
	{
		EnlaceDAO dao=new EnlaceDAO();
		try {
			return dao.obtenerTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return null;
		}		
	}
	
	public List<EnlaceDO> getEnlaces(){
		return this.obtenerTodosEnlaces();
	}
	
	/*
	 * Obtiene los 5 primeros enlaces alojados en la BD comenzando desde el comentario numero 'ini'
	 */
	public List<EnlaceDO> obtener5(List<EnlaceDO> todos,int ini){
		EnlaceDAO dao=new EnlaceDAO();
		try {
			return dao.obtener5(todos,ini);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return null;
		}		
    }
	
	/*
	 * Devuelve el numero de votos que tiene el enlace indicado tras sumarle uno
	 */
	public int aumentaVotos(String s){
		EnlaceDAO dao=new EnlaceDAO();
		try {
			return dao.aumentaVotos(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
    }
	
	/*
	 * Elimina los enlaces identificados mediante s y
	 * devuelve el numero de enlaces que han sido eliminados de la base de datos
	 */
	public int eliminaEnlace(String s){
		EnlaceDAO dao=new EnlaceDAO();
		try {
			return dao.eliminaEnlace(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
    }
	
	/*
	 * Añade un enlace a la base de datos y
	 * devuelve el numero de enlaces que han sido añadidos a la base de datos 
	 */
	public int subirEnlace(String s,String user){
		EnlaceDAO dao=new EnlaceDAO();
		try {
			return dao.subirEnlace(s,user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
    }
}
