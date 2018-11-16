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
	
	public UsuarioDO obtenerUsuario(String s)
	{
		UsuarioDAO dao=new UsuarioDAO();
		try {
			return dao.obtenerUsuario(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean actualizarUsuario(String username, String mail, int age, int estudios)
	{
		UsuarioDAO dao=new UsuarioDAO();
		try {
			return dao.actualizarUsuario(username,mail,age,estudios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public String ocupacion(int o) {
		return "TIC";
	}
	
	public String tipo(String t) {
		if(t=="p") {
			return "Profesor";
		}else if(t == "a") {
			return "Alumno";
		}else if(t == "u") {
			return "Usuario";
		}
		
		return "";
	}
	
	public UsuarioDO obtenerPepe() {
		UsuarioDO u = new UsuarioDO();
		u.setContr("contraseña");
		u.setEdad(21);
		u.setEstudios(1);
		u.setMail("pepe@mail.com");
		u.setNombre("Pepeito Grillo");
		u.setPuntos(8732);
		u.setTipo("u");
		u.setUsername("DestructorPepe");
		return u;
	}

}
