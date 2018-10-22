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
	            resultSet = statement.executeQuery("select * from arbitros_ejemplo");
	           
	            while (resultSet.next()) {
	                // It is possible to get the columns via name
	                // also possible to get the columns via the column number
	                // which starts at 1
	                // e.g. resultSet.getSTring(2);
	            	UsuarioDO user=new UsuarioDO();
	            	user.setLogin(resultSet.getString("login"));
	            	user.setNombre(resultSet.getString("nombre"));
	            	resultado.add(user);
	                
	            }
	            

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	        return resultado;

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
