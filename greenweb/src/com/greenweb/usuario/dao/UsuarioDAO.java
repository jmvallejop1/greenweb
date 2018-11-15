package com.greenweb.usuario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.greenweb.ConnectionManager;
import com.greenweb.usuario.data.UsuarioDO;

public class UsuarioDAO {

	
	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    public List<UsuarioDO> obtenerTodos() throws Exception {
	    	 List resultado=new LinkedList();
	        try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            resultSet = statement.executeQuery("select * from usuarios order by puntos desc");
	           
	            while (resultSet.next()) {
	                // It is possible to get the columns via name
	                // also possible to get the columns via the column number
	                // which starts at 1
	                // e.g. resultSet.getSTring(2);
	            	System.out.println(resultSet.getString("username"));
	            	UsuarioDO user=new UsuarioDO();
	            	user.setUsername(resultSet.getString("username"));
	            	user.setPuntos(Integer.parseInt(resultSet.getString("puntos")));
	            	resultado.add(user);         
	            }
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	        return resultado;

	    }
	    
	    public int anadirUsuario(UsuarioDO u) throws Exception {
	    	 List resultado=new LinkedList();
	        try {
	        	
	        	connect=ConnectionManager.getConnection();

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            //resultSet = statement.executeQuery("select titulo, texto, video from noticias");
	            //TODO consulta añadir usuario a base de datos y saber si ha ido bien
	            String query = "INSERT into enlaces VALUES ('"+u.getUsername()+ "','" + u.getContr() + "','" + u.getNombre() + "'"
	            		+ "'" + u.getMail() + "'," + u.getEstudios() + "," + u.getEdad() + "," +u.getPuntos() +",'"+u.getTipo()+"')";
	            System.out.println(query);
	            int how = statement.executeUpdate(query);
	           
	            return how;
	            

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	    }
	    
	    public boolean existeUsuario(String username) {
	    	try {
	    		connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            resultSet = statement.executeQuery("select * from usuarios where username='"+username+"'");
	            if(resultSet.next()) return true;
	            else return false;
	    	}
	    	catch(Exception e){
	    		//System.out.println("No se pudo ejecutar existeUsuario("+username+')');
	    	}
			return false;
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
