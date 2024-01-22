package com.DbConnection;


import  java.sql.Connection;
import java.sql.DriverManager;
public class DbConn{

	private static Connection conn;
	
	public static Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/crud";
    String username = "root"; 
    String password = "@Rajput007";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection(
		            url, username, password);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
}


