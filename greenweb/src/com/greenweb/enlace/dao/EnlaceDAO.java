package com.greenweb.enlace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.greenweb.ConnectionManager;
import com.greenweb.enlace.data.EnlaceDO;


public class EnlaceDAO{

	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    public List<EnlaceDO> obtenerTodos() throws Exception {
	    	 List<EnlaceDO> resultado=new LinkedList<EnlaceDO>();
	        try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            //Obtener los enlaces
	            resultSet = statement.executeQuery("select votos, url, iduploader from enlaces");
	           
	            while (resultSet.next()) {
	                // It is possible to get the columns via name
	                // also possible to get the columns via the column number
	                // which starts at 1
	                // e.g. resultSet.getSTring(2);
	            	//System.out.println(resultSet.getString("titulo"));
	            	EnlaceDO enlace =new EnlaceDO();
	            	//user.setLogin(resultSet.getString("login"));
	            	enlace.setId(resultSet.getString("iduploader"));
	            	enlace.setURL(resultSet.getString("URL"));
	            	enlace.setVotos(resultSet.getInt("votos"));
	            	resultado.add(enlace);	                
	            }
	            

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	        return resultado;

	    }
	    
	    public List<EnlaceDO> obtener5(List<EnlaceDO> todos,int ini){
	    	List<EnlaceDO> resultado=new LinkedList<EnlaceDO>();
	    	for(int i = ini;i<ini + 5;i++) {
	    		EnlaceDO enlace =new EnlaceDO();
	    		enlace = todos.get(i);
	    		resultado.add(enlace);
	    	}
	    	return resultado;
	    }
	    
	    public int aumentaVotos(String id) throws Exception{
	    	try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            //Obtener los enlaces
	           // String query = "SELECT * FROM enlaces WHERE url='"+ id +"'";
	            String query = "SELECT * FROM enlaces WHERE url='https://www.gengreenlife.com/'";
	            resultSet = statement.executeQuery(query);
	           
	            int numVotos= 0;
	            EnlaceDO enlace =new EnlaceDO();
	            while (resultSet.next()) {
	             	//user.setLogin(resultSet.getString("login"));
	             	enlace.setId(resultSet.getString("iduploader"));
	             	enlace.setURL(resultSet.getString("URL"));
	             	enlace.setVotos(resultSet.getInt("votos"));
	            	System.out.println("He actualizado los votos");
	            }
	            
	            numVotos = enlace.getVotos(); 
	           
	            System.out.println("Los votos de " + id + "son" + numVotos);
	            
	            numVotos++;
	            
	            System.out.println("Los nuevos votos de " + id + "son" + numVotos);
	            
	            return numVotos;

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	    }
	    
	    public int eliminaEnlace(String id) throws Exception{
	    	try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            //Obtener los enlaces
	            String query = "DELETE from enlaces where url="+id+"";
	            resultSet = statement.executeQuery(query);
	            
	           return 1;

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	    }
	    
	    public int subirEnlace(String id,String user) throws Exception{
	    	try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            //Obtener los enlaces
	            int votos = 0;
	            String query = "INSERT into enlaces values("+votos+ ",'"+id+"','"+user+"')";
	            int how = statement.executeUpdate(query);
	            
	           
	           return 1;

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
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