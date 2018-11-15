package com.greenweb.enlace;

import com.greenweb.enlace.data.*;
import com.greenweb.enlace.dao.EnlaceDAO;
import com.greenweb.enlace.data.EnlaceDO;
import com.greenweb.usuario.UsuarioManager;

import java.util.LinkedList;
import java.util.List;

import com.greenweb.enlace.dao.*;
public class EnlacesManager {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnlacesManager usu = new EnlacesManager();
		usu.obtenerTodosEnlaces();
		usu.aumentaVotos("hola");
	}
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
