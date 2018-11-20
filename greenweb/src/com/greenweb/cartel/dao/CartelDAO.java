package com.greenweb.cartel.dao;

import com.greenweb.cartel.data.*;
import com.greenweb.pregunta.dao.*;
import com.greenweb.pregunta.data.*;
import com.greenweb.noticia.dao.*;
import com.greenweb.noticia.data.*;
import com.greenweb.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CartelDAO {
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private static final int MAXCARTELESXENTREGA=20;
    
	public CartelDO obtenerCartelPreg(int idPreg) {
		CartelDO cartel=new CartelDO();
		PreguntaDO preg= new PreguntaDO();
		NoticiaDO not=new NoticiaDO();
		try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from preguntas where id="+idPreg);
            if(resultSet.next()) {
            	preg.setId(Integer.parseInt(resultSet.getString("id")));
            	preg.setPreg(resultSet.getString("preguntas"));
            	preg.setR1(resultSet.getString("resp1"));
            	preg.setR2(resultSet.getString("resp2"));
            	preg.setR3(resultSet.getString("resp3"));
            	preg.setR4(resultSet.getString("resp4"));
            	preg.setrOk(Integer.parseInt(resultSet.getString("respcorrecta")));
            }
            else preg=null;
            cartel.setPreg(preg);
            cartel.setIdPreg(idPreg);
            resultSet = statement.executeQuery("select * from noticias where id=(select idnoticia from carteles where idpreg="+idPreg+')');
            if(resultSet.next()) {
            	not.setId(Integer.parseInt(resultSet.getString("id")));
            	not.setTitulo(resultSet.getString("titulo"));
            	not.setTexto(resultSet.getString("texto"));
            	not.setVideo(resultSet.getString("video"));
            }
            else not=null;
            cartel.setIdNot(not.getId());
            cartel.setNoti(not);
            resultSet = statement.executeQuery("select * from carteles where idpreg="+idPreg);
            if(resultSet.next()) {
            	cartel.setId(Integer.parseInt(resultSet.getString("id")));
            	cartel.setFecha(resultSet.getString("fechasubida"));
            	cartel.setFoto(resultSet.getString("foto"));
            	String[] autores= new String[5];
            	autores[0]=resultSet.getString("creador1");
            	autores[1]=resultSet.getString("creador2");
            	autores[2]=resultSet.getString("creador3");
            	autores[3]=resultSet.getString("creador4");
            	autores[4]=resultSet.getString("creador5");
            	cartel.setCreadores(autores);
            }
            return cartel;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		System.out.println("No se pudo obtener la pregunta: "+preg.getId());
    	}
		 finally {
	            close();
	     }
		return cartel;
	}
	
	public CartelDO obtenerCartelNot(int idNot) {
		CartelDO cartel=new CartelDO();
		PreguntaDO preg= new PreguntaDO();
		NoticiaDO not=new NoticiaDO();
		try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from preguntas where id=(select idpreg from carteles where idnoticia="+idNot+')');
            if(resultSet.next()) {
            	preg.setId(Integer.parseInt(resultSet.getString("id")));
            	preg.setPreg(resultSet.getString("preguntas"));
            	preg.setR1(resultSet.getString("resp1"));
            	preg.setR2(resultSet.getString("resp2"));
            	preg.setR3(resultSet.getString("resp3"));
            	preg.setR4(resultSet.getString("resp4"));
            	preg.setrOk(Integer.parseInt(resultSet.getString("respcorrecta")));
            }
            else preg=null;
            cartel.setPreg(preg);
            cartel.setIdPreg(preg.getId());
            resultSet = statement.executeQuery("select * from noticias where id="+idNot);
            if(resultSet.next()) {
            	not.setId(Integer.parseInt(resultSet.getString("id")));
            	not.setTitulo(resultSet.getString("titulo"));
            	not.setTexto(resultSet.getString("texto"));
            	not.setVideo(resultSet.getString("video"));
            }
            else not=null;
            cartel.setIdNot(not.getId());
            cartel.setNoti(not);
            resultSet = statement.executeQuery("select * from carteles where idnoticia="+idNot);
            if(resultSet.next()) {
            	cartel.setId(Integer.parseInt(resultSet.getString("id")));
            	cartel.setFecha(resultSet.getString("fechasubida"));
            	cartel.setFoto(resultSet.getString("foto"));
            	String[] autores= new String[5];
            	autores[0]=resultSet.getString("creador1");
            	autores[1]=resultSet.getString("creador2");
            	autores[2]=resultSet.getString("creador3");
            	autores[3]=resultSet.getString("creador4");
            	autores[4]=resultSet.getString("creador5");
            	cartel.setCreadores(autores);
            }
            return cartel;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		System.out.println("No se pudo obtener la noticia: "+idNot);
    	}
		 finally {
	            close();
	     }
		return cartel;
	}
	
	public CartelDO obtenerRetoActual() {
		CartelDO c=new CartelDO();
		PreguntaDAO pdao=new PreguntaDAO(); 
		try {
			int idPRA=pdao.idPreguntaRetoActual();
			return obtenerCartelPreg(idPRA);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public List<CartelDO> obtenerEntregasActuales(){
		try {
			connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select max(num) from entregas");
            if(!resultSet.next()) return null;
            else return obtenerCartelesEntrega(Integer.parseInt(resultSet.getString("max(num)")));
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
		 finally {
	            close();
	     }
		return null;
	}
	
	public List<CartelDO> obtenerCartelesEntrega(int entrega){
		try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select idcar from entregados where ident="+entrega);
            int[] carteles=new int[MAXCARTELESXENTREGA];
            if(!resultSet.next()) return null;
            carteles[0]=Integer.parseInt(resultSet.getString("idcar"));
            int i=1;
            while(resultSet.next() && i<MAXCARTELESXENTREGA) {
            	carteles[i]=Integer.parseInt(resultSet.getString("idcar"));
            	i++;
            }
            //YA TENEMOS LOS IDS DE TODOS LOS CARTELES DE LA ENTREGA
            String idpregs="select idpreg from carteles where id="+carteles[0];
            for (int j=1; j<i; j++) {
            	idpregs+=" or id="+carteles[j];
            }
            System.out.println("Consulta: "+idpregs);
            connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            //AHORA OBTENDREMOS LOS IDS DE LAS PREGUNTAS ASOCIADAS PARA EXTRAER EL CARTEL
            resultSet = statement.executeQuery(idpregs);
            List<CartelDO> list= new LinkedList<CartelDO>();
            int pregs[]=new int[MAXCARTELESXENTREGA];
            i=0;
            while(resultSet.next()) {
            	pregs[i]=Integer.parseInt(resultSet.getString("idpreg"));
            	i++;
            }
            i--;
            while(i>=0) {
            	list.add(obtenerCartelPreg(pregs[i]));
            	i--;
            }
        	return list;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
		 finally {
	            close();
	     }
		return null;
		
	}
	
	public boolean obtenerCartelUsuario(String idUser, CartelDO c){
		try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            //Primero comprobaremos que el usuario haya entregado en esa entrega
            String SelultimaEntrega="select max(nument) from turnoent where iduser='"+idUser+'\'';
            resultSet = statement.executeQuery(SelultimaEntrega);
            int lastent=-1;
            if(resultSet.next()) lastent=Integer.parseInt(resultSet.getString("max(nument)"));
            else return false;
            System.out.println("ID RETO USUARIO:"+lastent);
            //Ahora veremos si se corresponde con la entrega vigente
            SelultimaEntrega="select max(num) from entregas";
            resultSet = statement.executeQuery(SelultimaEntrega);
            int entactual=-1;
            if(resultSet.next()) {
            	entactual=Integer.parseInt(resultSet.getString("max(num)"));
                System.out.println("ID ULTIMO RETO:"+lastent);
            	if(entactual==lastent && entactual!=-1) {
            		List<CartelDO> l= obtenerCartelesEntrega(entactual);
            		for(CartelDO car: l) {
            			String[] creadores=car.getCreadores();
            			for(int i=0; i< creadores.length; i++) {
            				System.out.println("Creador numero "+i+" es "+creadores[i]+" que se compara con "+idUser);
            				if(idUser.equals(creadores[i])) {
            					c.setCreadores(car.getCreadores());
            					c.setFecha(car.getFecha());
            					c.setFoto(car.getFoto());
            					c.setId(car.getId());
            					c.setIdNot(car.getIdNot());
            					c.setIdPreg(c.getIdPreg());
            					c.setNoti(car.getNoti());
            					c.setPreg(car.getPreg());
            					return true;
            				}
            			}
            		}
            		return false;
            	}
            	else return false;
            }
            else return false;            
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
		 finally {
	            close();
	     }
		return false;
	}
	
	//Sube un cartel nuevo
	public boolean subirCartel(CartelDO c) {
		boolean todoOk=false;
		try {
			if(existeCartel(c.getId())) {
				System.out.println("Ya existe un cartel con ese id");
				return false;
			}
            String[] autores=c.getCreadores();
            String insertCartel="insert into carteles values("+c.getId()+","+c.getIdPreg()+","+c.getIdNot();
            for(String s: autores) {
            	if(s==null) {
            		insertCartel+=", NULL";
            	}
            	else {
                	insertCartel+=",'"+s+'\'';
            	}
            }
            insertCartel+=",'"+c.getFecha()+"',";
            if(c.getFoto()==null) insertCartel+="NULL)";
            else insertCartel+=",'"+c.getFoto()+"')";
            System.out.println("Se ejecutara la siguiente instruccion: "+insertCartel);
            PreguntaDAO pdao=new PreguntaDAO();
        	NoticiaDAO ndao=new NoticiaDAO();
            if(pdao.anadirPregunta(c.getPreg()) && ndao.anadirNoticia(c.getNoti())) { //Añade la pregunta
            	connect=ConnectionManager.getConnection();
                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                // Result set get the result of the SQL query
            	System.out.println("Se ha anyadido la pregunta y la noticia correctamente");
                int insertados = statement.executeUpdate(insertCartel);
                if(insertados==1) {
                	System.out.println("Se han modificado lineas: "+insertados);
                	return true;            	   
                }
                else return false;
            }
            System.out.println("Fin funcion subir");
            return todoOk;
		}
		catch (Exception e) {
            e.printStackTrace();
	     }
   	 finally {
	            close();
	     }
		return todoOk;
	}
	
	public CartelDO generaCartel(PreguntaDO p, NoticiaDO n, String[] autores, int idp, int idn, String foto, String fecha) {
		CartelDO c= new CartelDO();
		try {
    		int idc=numCarteles() +1;
    		c.setId(idc);
    		c.setCreadores(autores);
    		c.setFecha(fecha);
    		c.setFoto(foto);
    		c.setIdNot(idn);
    		c.setIdPreg(idp);
    		c.setNoti(n);
    		c.setPreg(p);
    		return c;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
		 finally {
	            close();
	     }
    	return c;
	}
	
	public boolean existeCartel(int idc) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from carteles where id="+idc);
            if(resultSet.next()) return true;
            else return false;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
    	 finally {
	            close();
	     }
		return false;
    }
	
	public int numCarteles() {
		int res=-1;
		try {
	    	connect=ConnectionManager.getConnection();
	        // Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();
	        // Result set get the result of the SQL query
	    	String cuenta="select count(id) from carteles";
	    	resultSet=statement.executeQuery(cuenta);
			if(resultSet.next()) {
	        	res=Integer.parseInt(resultSet.getString("count(id)"));
			}
			return res;
		}
		catch (Exception e) {
	        e.printStackTrace();
		}finally {
	        close();
		}
		return res;
	}

	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
