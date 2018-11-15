package com.greenweb.comentario.data;

public class ComentarioDO 
{
	private String idUser;
	private String comentario;
	private String fecha;
	
	
	// Constructor
	public ComentarioDO() {
		super();
	}


	// devolver nombre de Usuario
	public String getIdUser() {
		return idUser;
	}


	// iniciar nombre de usuario
	public void setIdUser(String clave) {
		this.idUser = clave;
	}
	

	// devolver nombre de imagen
	public String getComentario() {
		return comentario;
	}


	// iniciar imagen
	public void setComentario(String c) {
		this.comentario = c;
	}


	// devolver contenido
	public String getFecha() {
		return fecha;
	}


	// iniciar descripcion
	public void setFecha(String f) {
		this.fecha = f;
	}
	

}
