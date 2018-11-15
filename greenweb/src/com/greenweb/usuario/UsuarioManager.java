package com.greenweb.usuario;

import java.util.List;

import com.greenweb.usuario.data.*;
import com.greenweb.usuario.dao.*;

public class UsuarioManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioManager usu = new UsuarioManager();
		usu.obtenerTodosUsuarios();
		System.out.println("hola");
	}
	
	public List<UsuarioDO> obtenerTodosUsuarios()
	{
		UsuarioDAO dao=new UsuarioDAO();
		try {
			return dao.obtenerTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}	
	}
	
	public int anadirUsuario(UsuarioDO u)
	{
		UsuarioDAO dao=new UsuarioDAO();
		try {
			return dao.anadirUsuario( u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}	
	}
	
	public boolean existeUsuario(String s)
	{
		UsuarioDAO dao=new UsuarioDAO();
		try {
			return dao.existeUsuario(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return true;
		}	
	}


}
