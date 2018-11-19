package com.greenweb.usuario.data;

import com.greenweb.usuario.UsuarioManager;

public class UsuarioDO 
{
	private String nombre;
	private String username;
	private String mail;
	private String contr;
	private int edad;
	private int puntos;
	private int estudios;
	private String tipo;
	private String loadUsername;

	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String contr) {
		this.contr = contr;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getEstudios() {
		return estudios;
	}
	public void setEstudios(int estudios) {
		this.estudios = estudios;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;		
	}
	
	public void setLoadUsername(String username) {
		UsuarioManager u = new UsuarioManager();
		UsuarioDO udo= u.obtenerUsuario(username);	
		this.nombre = udo.getNombre();
		this.username = username;
		this.mail = udo.getMail();
		this.contr = udo.getContr();
		this.edad = udo.getEdad();
		this.puntos = udo.getPuntos();
		this.tipo = udo.getTipo();
		this.estudios = udo.getEstudios();			
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
