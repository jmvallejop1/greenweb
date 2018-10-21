package com.greenweb;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
        // Setup the connection with the DB
        Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost/sisInfBD?"
                        + "user=usuarioSIBD&password=claveSIBD");
        return conn;
	}
}
