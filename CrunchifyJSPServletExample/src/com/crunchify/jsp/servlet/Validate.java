package com.crunchify.jsp.servlet;

import java.sql.*;

public class Validate {

	private static Connection conn = null;
	private static ResultSet rs = null;
	
	public static Student checkValid(Student student) {
		
		String firstname = student.getFirstName();
		String lastname = student.getLastName();
		String username = student.getUsername();
		String password = student.getPassword();
	
		try {
			
			conn = DbConn.getConnection();

 			String query  = "select * from Students where username = ? and password = ?";			
			
 			PreparedStatement ps = conn.prepareStatement(query);
 			
 			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			boolean more = rs.next();
			
			if(!more) {
				System.out.println("Sorry, you have not registered, Please register first!");
				student.setValid(false);
			}
			else if (more){
				System.out.print("Welcome " + firstname + " " + lastname);
				student.setValid(true);
			}
			
			ps.close();
			rs.close();

		}catch (Exception ex) { System.out.println("Log In failed: An Exception has occurred! " + ex);}
		
		
		return student;
	}
}	
