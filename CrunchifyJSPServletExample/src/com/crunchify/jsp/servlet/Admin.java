package com.crunchify.jsp.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	
	public boolean isAdmin(String username, String password) throws SQLException {
		
		Connection conn = null;
		try {
			conn = DbConn.getConnection();
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		
		String query  = "select * from admin_user where username = ? and password = ?";			
		
		PreparedStatement ps = conn.prepareStatement(query);
			
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		boolean more = rs.next();
		
		System.out.println(more);
		
		if(more){
			return true;
		}
		ps.close();
		rs.close();
		return false;	
	}
}
