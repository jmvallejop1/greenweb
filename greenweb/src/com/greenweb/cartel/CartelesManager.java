package com.greenweb.cartel;
import com.greenweb.cartel.dao.*;
import com.greenweb.cartel.data.*;
import com.greenweb.noticia.data.*;
import com.greenweb.noticia.dao.*;
import com.greenweb.pregunta.dao.*;
import com.greenweb.pregunta.data.*;

import java.util.LinkedList;
import java.util.List;

public class CartelesManager {
	
			public static void main(String[] args) {
				CartelesManager manager = new CartelesManager();
				CartelDO c=manager.obtenerCartelP(1);
				PreguntaDAO pdao=new PreguntaDAO();
				String[] autores= c.getCreadores();
				System.out.println("El cartel obtenido a partir de la pregunta 1 es:\n"
						+ c.getId() + "--->" + "Noticia: "+c.getIdNot()+" Pregunta: "+c.getIdPreg()+"\n Autores: "+autores[0]+", "+autores[1]+", "+autores[2]+", "+autores[3]+", "+autores[4]+
						"\nFecha: "+c.getFecha());
				c=manager.obtenerCartelN(1);
				PreguntaDO p=pdao.crearP("Quien ganara el premio nobel?", "ruben", "castro", "rabanaque", "rabatanque", 2);
				NoticiaDO n = new NoticiaDO();
				n.setId(15); n.setTexto("Los grandes expertos creen que castro y rabatanque son los grandes de este anyo"); n.setTitulo("El premio"); n.setVideo(null);
				int idp=p.getId();
				CartelDO c2=manager.crearCartel(p,n,autores,idp,15,null,"2018-10-01");
				if(manager.subirCartel(c2))System.out.print("El cartel se ha subido con exito");
				else System.out.println("No se ha podido subir el cartel introducido");
				
				autores= c.getCreadores();
				System.out.println("El cartel obtenido a partir de la pregunta 1 es:\n"
						+ c.getId() + "--->" + "Noticia: "+c.getIdNot()+" Pregunta: "+c.getIdPreg()+"\n Autores: "+autores[0]);
				System.out.println("fin main");
			}
			
			public CartelDO obtenerCartelP(int idPreg){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelPreg(idPreg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
					return null;
				}		
			}
			public CartelDO obtenerCartelN(int idNot){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelNot(idNot);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
					return null;
				}		
			}
			
			public boolean subirCartel(CartelDO c) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.subirCartel(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
				}
				return false;
			}
			
			public CartelDO crearCartel(PreguntaDO p, NoticiaDO n, String[] autores, int idp, int idn, String foto, String fecha) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.generaCartel(p,n,autores,idp,idn,foto,fecha);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			
				}
				return null;
			}
			/*
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

	}*/
}
