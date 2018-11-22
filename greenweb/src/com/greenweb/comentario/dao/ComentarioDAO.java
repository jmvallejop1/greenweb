package com.greenweb.comentario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.greenweb.ConnectionManager;
import com.greenweb.comentario.data.ComentarioDO;
import com.greenweb.usuario.data.UsuarioDO;

public class ComentarioDAO {

	
	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    // mostrar comentarios OK
	    public LinkedList<ComentarioDO> listarComentarios() throws Exception {
	    	LinkedList<ComentarioDO> resultado=new LinkedList();
	        try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	           
	           
	            resultSet = statement.executeQuery("select idUser, comentario , fecha from comentarios");
	            
	            while (resultSet.next()) {
	            	// generar un dato de tipo ForoDO
	            	ComentarioDO coment = new ComentarioDO();
	            	
	            	// Creaci�n del dato comentario
	            	coment.setIdUser(resultSet.getString("idUser"));
	            	coment.setComentario(resultSet.getString("comentario"));
	            	coment.setFecha(resultSet.getString("fecha"));
	            	
	            	resultado.add(coment);
	            }
	            
	 
            	for (int i = 0; i < resultado.size(); i++) {
            		System.out.println(resultado.get(i).getIdUser() 
            				+ " " + resultado.get(i).getComentario() 
            				+ " " + resultado.get(i).getFecha());
            	}
            	
            	
            	
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	        return resultado;
	    }
	    
		// guardar Comentario; OK
		public boolean anyadirComentario(ComentarioDO c) {
			boolean resul=false;
	    	try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            String insert="insert into comentarios VALUES ('" + c.getIdUser() + "','" + c.getComentario() + "','" + c.getFecha() +"')";
	      	    int res=statement.executeUpdate(insert);
	    	}
	    	catch (Exception e) {
	            //throw e;
	    	}
	    	finally {
	            close();
	    	}
	    	return resul;
	    }
		    
	    // borrar comentario OK
		public boolean eliminarComentario(ComentarioDO c) {
	    	boolean resul=false;
	    	try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	        	String delete= "delete from comentarios where idUser = '" + c.getIdUser() + "'";
	            int res=statement.executeUpdate(delete);
	            resul=res==1;
	    	}
	    	catch (Exception e) {
	            //throw e;
	    	}
	    	finally {
	            close();
	    	}
	    	return resul;
	    }
		
		
		// Contar comentarios totales OK
		public int numComentarios() {
			int resul = 0;
	    	int res=-1;
	    	try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	        	String cuenta="select count(idUser) from comentarios";
	        	resultSet=statement.executeQuery(cuenta);
	        	if (resultSet.next()) {
	        		resul=Integer.parseInt(resultSet.getString("count(idUser)"));
	        		return resul;
	        	}
	        	else {
	        		return -1;
	        	}
	    	}
	    	catch (Exception e) {
	            //throw e;
	    		return -2;
	    	}
	    	finally {
	            close();
	    	}
	    }
	    
		//contar preguntas de un usuario concreto
		public int contarPreguntasUser (ComentarioDO c) {
			int cuenta = 1;
			try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            String idUsuario = c.getIdUser();
	            
	            // Obtenemos las preguntas de un usuario
	        	String consulta="select count(idUser) from preguntas where idUser = '" + idUsuario + '\'';
	        	resultSet=statement.executeQuery(consulta);
				if(resultSet.next()) {
		        	cuenta=Integer.parseInt(resultSet.getString("count(*)"));
				}
	    	}
	    	catch (Exception e) {
	            //throw e;
	    	}finally {
	            close();
	    	}
	    	return cuenta;
		}
		
		
		// comprobar si un usuario <<idUser>> ha comentado
		boolean existeComentario (String idUser) throws Exception {
			
			List<ComentarioDO> lista;
			lista = listarComentarios();
			
			int cap = lista.size();
			boolean encontrado = false;
			int i = 0;
			
			while (!encontrado && i < cap) {
				// Verificamos si es un comentario del usuario buscado
				if (idUser.equals(lista.get(i).getIdUser())) {
					encontrado = true;
				}
				else {
					i = i + 1;
				}
				
			}
			return encontrado;
		}
		
		
	    // You need to close the resultSet
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

	        }
	        
	     
	    }


}
