package com.greenweb.noticia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.greenweb.ConnectionManager;
import com.greenweb.comentario.data.ComentarioDO;
import com.greenweb.noticia.data.NoticiaDO;
import com.greenweb.usuario.data.UsuarioDO;

public class NoticiaDAO {

	
	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    // mostrar noticias OK
	    public LinkedList<NoticiaDO> listarNoticias() throws Exception {
	    	LinkedList<NoticiaDO> resultado=new LinkedList();
	        try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	           
	           
	            resultSet = statement.executeQuery("select id, titulo , texto, video from noticias");
	            
	            while (resultSet.next()) {
	            	// generar un dato de tipo ForoDO
	            	NoticiaDO noticia = new NoticiaDO();
	            	
	            	// Creaci�n del dato comentario
	            	noticia.setId(resultSet.getInt("id"));
	            	noticia.setTitulo(resultSet.getString("titulo"));
	            	noticia.setTexto(resultSet.getString("texto"));
	            	noticia.setVideo(resultSet.getString("video"));
	            	
	            	resultado.add(noticia);
	            }
	            
	 
            	for (int i = 0; i < resultado.size(); i++) {
            		System.out.println(resultado.get(i).getId() 
            				+ " " + resultado.get(i).getTitulo() 
            				+ " " + resultado.get(i).getTexto()
            				+ " " + resultado.get(i).getVideo());
            	}
            	
            	
            	
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	        return resultado;
	    }
	    
		// guardar Comentario; OK
		public boolean anadirNoticia(NoticiaDO c) {
			boolean resul=false;
	    	try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            String insert="insert into noticias VALUES (" + c.getId() + ",'" + c.getTitulo() + "','" + c.getTexto() + "','" + c.getVideo() + "')";
	      	    int res=statement.executeUpdate(insert);
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
		    
	    // borrar comentario OK
		public boolean eliminarNoticia(NoticiaDO c) {
	    	boolean resul=false;
	    	try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	        	String delete= "delete from noticias where id = '" + c.getId() + "'";
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

