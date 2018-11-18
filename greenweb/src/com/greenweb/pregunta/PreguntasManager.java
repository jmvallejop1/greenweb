package com.greenweb.pregunta;
//import java.util.Iterator;
import java.util.List;
import com.greenweb.pregunta.data.*;
import com.greenweb.cartel.dao.CartelDAO;
import com.greenweb.cartel.data.CartelDO;
import com.greenweb.pregunta.dao.*;

public class PreguntasManager {
	
	public static void main(String[] args) throws Exception {
		PreguntasManager pregM = new PreguntasManager();
		/*//pregM.listarTodas();
		List<PreguntaDO> lista = pregM.obtenerTodasPreguntas();
		System.out.println("Uee mecauenla");
		//pregM.listar(lista);
		System.out.println("Vamos a coger las 5 preguntas primeras");
		PreguntaDAO daoP=new PreguntaDAO();
		List<PreguntaDO> lista2=daoP.obtener5(lista, 3);
		pregM.listar(lista2);
		if(pregM.anyadirPregunta("Cuantas piernas tiene un perro?", "1", "2", "0", "Nose", 3)) {
			System.out.println("Se ha introducido la pregunta, mostrando la lista a continuación:");
			//pregM.listarTodas();
		}
		else {
			System.out.println("No se ha introducido la pregunta.");
		}
		System.out.println("-----------------------------------------Ahora respondemos----------------------------------------");
		if(pregM.responderPregAdicionalRA("sk8", 4, 3)) {
			System.out.println("sk8 ha respondido a la pregunta");
		}
		else {
			System.out.println("sk8 no ha podido responder la pregunta del reto actual");
		}
		System.out.println("-----------------------------------------fin respuesta----------------------------------------");

		System.out.println("El main ha terminado");
	*/
		System.out.println("El usuario ha contestado a la pregunta y la respuesta ha sido: "+pregM.responderPreg("pepe", 1, 9));
	}
	
	
	public int idPregActual() throws Exception {
		PreguntaDAO dao = new PreguntaDAO();
		try {
			return dao.idPreguntaRetoActual();
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public void listar(List<PreguntaDO> list) throws Exception {
		PreguntaDAO dao = new PreguntaDAO();
		try {
			dao.listar(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarTodas() throws Exception {
		PreguntaDAO dao = new PreguntaDAO();
		try {
			dao.listarTodas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PreguntaDO> obtenerTodasPreguntas(){
		PreguntaDAO dao=new PreguntaDAO();
		try {
			return dao.obtenerPreguntas();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//NO SE NECESITA
	public boolean obtenerPregunta(int id, PreguntaDO p) {
		PreguntaDAO dao=new PreguntaDAO();
		try {
			return dao.obtenerPregunta(id, p);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//FUNCIONA
	public boolean anyadirPregunta(String preg, String r1, String r2, String r3, String r4, int resOK) {
		PreguntaDAO dao=new PreguntaDAO();
		try {
			PreguntaDO pregunta=dao.crearP(preg, r1, r2, r3, r4, resOK);
			//Primero creamos una pregunta y ahora la añadimos
			System.out.println("Creada la pregunta con id="+pregunta.getId());
			return dao.anadirPregunta(pregunta);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	//FUNCIONA
	public boolean borrarPregunta(int idp) {
		PreguntaDAO dao = new PreguntaDAO();
		try {
			System.out.println("Entrando en borrarDAO");
			return dao.borrarPregunta(idp);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//FUNCIONA
	public boolean borrarPregunta(String preg) {
		PreguntaDAO dao=new PreguntaDAO();
		PreguntasManager man= new PreguntasManager();
		try {
			int idP=dao.idPregunta(preg);
			System.out.println("La pregunta tiene el id: "+idP);
			return man.borrarPregunta(idP);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
*/
	public boolean responderPreguntaRA(String idU, int res) {
		PreguntaDAO dao=new PreguntaDAO();
		try {
			return dao.responderPregRetoActual(idU, res);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean responderPregAdicionalRA(String idU, int res, int idPreg) {
		PreguntaDAO dao=new PreguntaDAO();
		try {
			return dao.responderPregRetoAdicional(idU, res, idPreg);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public int responderPreg(String idU, int res, int idPreg) {
		PreguntaDAO dao=new PreguntaDAO();
		try {
			return dao.responderPreg(idU, res, idPreg);
		} catch (Exception e){
			e.printStackTrace();
			return -1;
		}
	}
}
