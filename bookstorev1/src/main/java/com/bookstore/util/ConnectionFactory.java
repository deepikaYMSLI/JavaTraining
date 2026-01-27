package com.bookstore.util;
import java.sql.*;

public class ConnectionFactory {
	//private static Connection connection;
	private static final String url = "jdbc:mysql://localhost:3306/ymsli";
	private static final String user = "root";
	private static final String pass = "root";
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("My SQL Driver not found", e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(url, user, pass);
		
	}

}
