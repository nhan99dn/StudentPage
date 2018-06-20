package com.crunchify.jsp.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String address = "jdbc:mysql://localhost:3306/myDB?useSSL=false";
		String user = "root";
		String password = "Hanhnhan160315";
		
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		
		try {
			conn = DriverManager.getConnection(address, user, password);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
}
