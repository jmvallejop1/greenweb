package com.greenweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;



public class ConnectionManager {
	static Connection connection = null;
	
	public static void main(String[] args) throws Exception {
		getConnection();
	}
	
	public static Connection getConnection() throws Exception {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://" + "ec2-18-209-57-195.compute-1.amazonaws.com" + ":" + "3306" + "/" +"greenweb"+ "?user=" + "practicas_si" + "&password=" + "sisinfo" + "&useSSL=false";
		//connection = DriverManager.getConnection("jdbc:mysql://ec2-18-209-57-195.compute-1.amazonaws.com:3306/greenweb","root","toor");
		connection = DriverManager.getConnection(url);
		//Connection con=DriverManager.getConnection(  
		//		 "jdbc:mysql://localhost:3306/sonoo","root","root")
        // Setup the connection with the DB
        
		//connection = DriverManager.getConnection("jdbc:oracle:thin:@hendrix-oracle.cps.unizar.es:1521:vicious","a738435","zt3hh5");
        return connection;
	}	
}