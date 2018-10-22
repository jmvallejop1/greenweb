package com.greenweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;



public class ConnectionManager {
	static Connection connection = null;
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
        // Setup the connection with the DB
        connection = DriverManager.getConnection("jdbc:oracle:thin:@hendrix-oracle.cps.unizar.es:1521:vicious","a738435","zt3hh5");
        return connection;
	}
	

}