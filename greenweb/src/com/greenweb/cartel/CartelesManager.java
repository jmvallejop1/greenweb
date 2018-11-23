package com.greenweb.cartel;
import com.greenweb.cartel.dao.*;
import com.greenweb.cartel.data.*;
import com.greenweb.noticia.data.*;
import com.greenweb.pregunta.data.*;

import java.util.List;

public class CartelesManager {
			int idn;
			int idp;
			CartelDO noticia;
			CartelDO preg;
			
			public static void main(String[] args) {
				/*CartelesManager cman=new CartelesManager();
				//CartelDAO dao=new CartelDAO();
				//List<CartelDO> l=new LinkedList<CartelDO>();
				//l=dao.obtenerEntregasActuales();
				//l=dao.obtenerCartelesEntrega(11);
				
				//CartelesManager manager = new CartelesManager();
				CartelDO c=new CartelDO();
				if(cman.obtenerCartel("pepe2", c))System.out.println("Obtenido cartel con id="+c.getId());
				else System.out.println("No obtenido cartel");
				/*PreguntaDAO pdao=new PreguntaDAO();
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
				
				CartelDO c=new CartelDO();
				int x=l.size();
				System.out.println("Carteles pertenecientes a la entrega actual: ");
				for (int i=0; i<x; i++) {
					c=l.get(i);
					System.out.println(c.getId());
				}
				System.out.println("fin main");
				*/
			}
			
			public int getIdn() {
				return idn;
			}

			public void setIdn(int idn) {
				this.idn = idn;
				this.noticia = this.obtenerCartelN(idn);
			}

			public int getIdp() {
				return idp;
			}

			public void setIdp(int idp) {
				this.idp = idp;
				this.preg = this.obtenerCartelP(idp);
			}
			
			public CartelDO getNoticia() {
				return noticia;
			}


			public void setNoticia(CartelDO noticia) {
				this.noticia = noticia;
			}


			public CartelDO getPreg() {
				return preg;
			}
			
			public CartelDO getCartel(){
				return this.obtenerRetoActual();
			}


			public void setPreg(CartelDO preg) {
				this.preg = preg;
			}
			
			/*
			 * Pre: -
			 * Post: Devuelve true si se ha logrado sumar un voto
			 * al cartel identificado mediante 'idcartel' en la base de datos.
			 * En caso contrario devuelve false
			 */
			public boolean sumarVoto(int idcartel) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.sumarVoto(idcartel);
				} catch (Exception e) {
					e.printStackTrace();			
					return false;
				}	
			}
			
			/*
			 * Pre: -
			 * Post: devuelve true si existe un cartel identificado
			 * mediante 'idpreg' en la base de datos y se ha logrado obtener sus datos
			 * En caso contrario devuelve false
			 */
			public CartelDO obtenerCartelP(int idPreg){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelPreg(idPreg);
				} catch (Exception e) {
					e.printStackTrace();			
					return null;
				}		
			}
			
			/*
			 * Pre: idNot se corresponde con el id de una noticia y esta asociado a un cartel c
			 * Post: Devuelve el cartel c
			 */
			public CartelDO obtenerCartelN(int idNot){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelNot(idNot);
				} catch (Exception e) {
					e.printStackTrace();			
					return null;
				}		
			}
			
			/*
			 * Pre: -
			 * Post: Devuelve el cartel asociado al reto en marcha actualmente
			 */
			public CartelDO obtenerRetoActual() {
				try {
					CartelDAO dao = new CartelDAO();
					return dao.obtenerRetoActual();
				}
				catch (Exception e) {
					e.printStackTrace();			
				}
				return null;
			}
			
			/*
			 * Pre: entrega debe ser un entero cuyo valor se asocia a una entrega en la base de datos
			 * Post: Devuelve una lista con todos los carteles que se hayan
			 * entregado durante la entrega indicada
			 */
			public List<CartelDO> obtenerCartelesEntrega(int entrega){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelesEntrega(entrega);
				} catch (Exception e) {
					e.printStackTrace();			
					return null;
				}
			}
			
			/*
			 * Pre: -
			 * Post: Devuelve una lista que contiene todos los carteles entregados
			 * en la entrega que está en curso actualmente
			 */
			public List<CartelDO> obtenerCartelesActuales(){
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerEntregasActuales();
				} catch (Exception e) {
					e.printStackTrace();			
				}
				return null;
			}
			
			/*
			 * Pre: -
			 * Post: devuelve true si se logra introducir el cartel c en la base de datos
			 * devuelve false en caso contrario
			 */
			public boolean subirCartel(CartelDO c) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.subirCartel(c);
				} catch (Exception e) {
					e.printStackTrace();			
				}
				return false;
			}
			
			/*
			 * Pre: -
			 * Post: devuelve true si se ha conseguido obtener el cartel entregado en el turno actual
			 * asociado al usuario de la base de datos 
			 */
			public boolean obtenerCartel(String user,CartelDO c) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.obtenerCartelUsuario(user, c);
				} catch (Exception e) {
					e.printStackTrace();			
				}
				return false;
			}
			
			/*
			 * Pre: -
			 * Post: devuelve un cartel relleno con los campos indicados
			 */
			public CartelDO crearCartel(PreguntaDO p, NoticiaDO n, String[] autores, int idp, int idn, String foto, String fecha) {
				CartelDAO dao=new CartelDAO();
				try {
					return dao.generaCartel(p,n,autores,idp,idn,foto,fecha);
				} catch (Exception e) {
					e.printStackTrace();			
				}
				return null;
			}
}