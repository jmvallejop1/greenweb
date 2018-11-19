package com.greenweb.cartel.data;

import com.greenweb.noticia.data.NoticiaDO;
import com.greenweb.pregunta.data.PreguntaDO;

public class CartelDO {
	private int id;
	private int idPreg;
	private int idNot;
	private String[] creadores;
	private String fecha;
	private String foto;
	//Ahora va la pregunta y la noticia
	private PreguntaDO preg;
	private NoticiaDO noti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPreg() {
		return idPreg;
	}
	public void setIdPreg(int idPreg) {
		this.idPreg = idPreg;
	}
	public int getIdNot() {
		return idNot;
	}
	public void setIdNot(int idNot) {
		this.idNot = idNot;
	}
	public String[] getCreadores() {
		return creadores;
	}
	public void setCreadores(String[] creadores) {
		this.creadores = creadores;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public PreguntaDO getPreg() {
		return preg;
	}
	public void setPreg(PreguntaDO preg) {
		this.preg = preg;
	}
	public NoticiaDO getNoti() {
		return noti;
	}
	public void setNoti(NoticiaDO not) {
		this.noti = not;
	}
}
