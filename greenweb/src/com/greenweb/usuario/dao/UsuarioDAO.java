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
	    
	    public static void main(String[] args) throws Exception{
	    	UsuarioDAO d = new UsuarioDAO();
	    	if(d.existeUsuario("pepeoew")) {
	    		System.out.println("existe");
	    	}else {
	    		d.anadirUsuario(d.obtenerPepe());
	    	}
	    }
	    public UsuarioDO obtenerPepe() {
			UsuarioDO u = new UsuarioDO();
			u.setContr("contrasena");
			u.setEdad(21);
			u.setEstudios(1);
			u.setMail("pepe@mail.com");
			u.setNombre("Pepeito Grillo");
			u.setPuntos(8732);
			u.setTipo("u");
			u.setUsername("DestructorPepe");
			return u;
		}
	    
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
	            //TODO consulta a�adir usuario a base de datos y saber si ha ido bien
	            String query = "INSERT into usuarios VALUES ('"+u.getUsername()+ "','" + u.getContr() + "','" + u.getNombre() + "'"
	            		+ ",'" + u.getMail() + "'," + u.getEstudios() + "," + u.getEdad() + "," +u.getPuntos() +",'"+u.getTipo()+"')";
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
	            resultSet = statement.executeQuery("select * from usuarios where username = '"+username+"'");
	            if(resultSet.next()) return true;
	            else return false;
	    	}
	    	catch(Exception e){
	    		//System.out.println("No se pudo ejecutar existeUsuario("+username+')');
	    	}finally {
	            close();
	        }
	    	return false;
			
	    }
	    
	    public boolean actualizarUsuario(String id, String mail, int age, int estudios) {
	    	try {
	    		String Update = " SET";
	    		int how = 0;
	    		if(mail!=null && mail!="") {	
	    				Update += " email = '" + mail + "',";
	    		}
	    		
	    		if(age!=0) {	
    				Update += " edad = " + age +",";
	    		}
	    		
	    		if(estudios!=0) {	
    				Update += " ocupacion = '" + estudios + "'";
	    		}
	    		
	    		if(Update != null && Update != "") {
	    		Update = "UPDATE usuarios"+ Update + " WHERE username = '"+ id +"'";
	    		connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            System.out.println("La consulta a realizar es:"+ Update);
	            how = statement.executeUpdate(Update);         
	            how = 1;
	            if(how == 1) return true;
	            else return false;
	    		}else {
	    			System.out.println("No se han rellenado campos");
	    			return false;
	    		}
	           
	    	}
	    	catch(Exception e){
	    		//System.out.println("No se pudo ejecutar existeUsuario("+username+')');
	    	}finally {
	            close();
	        }
	    	return false;
			
	    }
	    
	    public UsuarioDO obtenerUsuario(String username) throws Exception {
	    	try {
	    		connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            UsuarioDO us=new UsuarioDO();
	            System.out.println("select * from usuarios where username = '"+ username +"'");
	            resultSet = statement.executeQuery("select * from usuarios where username = '"+ username +"'");
	            
	            while (resultSet.next()) {
	                // It is possible to get the columns via name
	                // also possible to get the columns via the column number
	                // which starts at 1
	                // e.g. resultSet.getSTring(2);
	            	System.out.println(resultSet.getString("username"));            	
					us.setUsername(resultSet.getString("username"));
					us.setNombre(resultSet.getString("nombre"));
					us.setMail(resultSet.getString("email"));
					us.setContr(resultSet.getString("passwd"));
					us.setEdad(Integer.parseInt(resultSet.getString("edad")));
					us.setEstudios(Integer.parseInt(resultSet.getString("ocupacion")));
					us.setPuntos(Integer.parseInt(resultSet.getString("puntos")));
					us.setTipo(resultSet.getString("tipo"));
	            }
	            return us;
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    		return null;
	    	}finally {
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
