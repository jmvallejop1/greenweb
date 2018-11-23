package com.greenweb.entrega;

import com.greenweb.entrega.dao.*;
import com.greenweb.cartel.data.*;


public class EntregaManager {
	public static void main(String[] args) {
		try {/*
			EntregaManager eman=new EntregaManager();
			EntregaDAO edao=new EntregaDAO();
			CartelDAO cdao=new CartelDAO();
			PreguntaDO pdao=new PreguntaDO();/*
			String fecha=edao.fechaEntrega("al6a");
			System.out.println("La fecha de la ultima entrega es: "+fecha);
			fecha=edao.fechaModificacion("al6a");
			System.out.println("La fecha de la ultima modificacion es: "+fecha);
			if(edao.haEntregado("sk8")) System.out.println("sk8 ha entregado el reto");
			else System.out.println("sk8 no ha entregado aun");
			CartelDO c=cdao.obtenerCartelPreg(4);
			System.out.println("El cartel obtenido a partir de la pregunta 4 es: "+c.getId() +" cuya noticia correspondiente es: "+c.getIdNot());
			PreguntaDO p=c.getPreg();
			NoticiaDO n=c.getNot();
			n.setId(12);
			p.setrOk(2);
			p.setPreg("Funcionara anadir la entrega?");
			p.setId(12);
			String[] creadores= {"pepe2","alfon2",null, null,null};
			c.setCreadores(creadores);
			c.setPreg(p);
			c.setIdPreg(12);
			c.setIdNot(12);
			c.setId(10);
			//if(edao.subirEntrega("pepe2", c)) System.out.println("Se ha subido con exito");
			edao.iniciarReto(10);
			//if(edao.nuevaEntrega("2019-01-01"))System.out.println("Se ha añadido entrega nueva");
			if(eman.anadirEntrega("12-12-2018"))System.out.println("Entrega nueva añadida");
			//if(edao.puedeEntregar("apu")) System.out.println("pepe2 puede entregar");
			//else System.out.println("No puede entregar, no le corresponde el turno");
			//System.out.println("Fin del main");*/
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
		
	public boolean haEntregado(String iduser) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.puedeEntregar(iduser);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean NuevoReto(int idcart) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.iniciarReto(idcart); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int numEntrega(String fecha) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.numEntrega(fecha); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean asignarEntrega(String alumno, int entrega) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.setNumEntrega(alumno, entrega); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String fechaModificacion(String iduser) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.fechaModificacion(iduser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String fechaEntrega(String iduser) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.fechaEntrega(iduser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean subirEntrega(String iduser, CartelDO c) {
		try {
			EntregaDAO dao=new EntregaDAO();
			return dao.subirEntrega(iduser, c); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean anadirEntrega(String fechalimite) {
		try {
			EntregaDAO edao=new EntregaDAO();
			return edao.nuevaEntrega(fechalimite); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
