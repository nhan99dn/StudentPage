package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newFirstname = request.getParameter("firstname");
		String newLastname = request.getParameter("lastname");
		String newYear = request.getParameter("year");
		String newSchool = request.getParameter("school");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		if (newFirstname.isEmpty() || newLastname.isEmpty() || newYear.isEmpty() || newSchool.isEmpty() || username.isEmpty() || password.isEmpty()) {
			
			 RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp");
			 out.println("<font color=red>Please fill all the fields</font>");
			 rd.include(request, response);
			 
		}else {	
			try {
				
				Connection conn = DbConn.getConnection();
				
				String query = "Update Students "
						+ "Set firstName =  ?,"
						+ "lastName = ?,"
						+ "year = ?,"
						+ "school = ?"
						+ "where username = ? and password = ?;";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, newFirstname);
				ps.setString(2, newLastname);
				ps.setString(3, newYear);
				ps.setString(4, newSchool);
				ps.setString(5, username);
				ps.setString(6, password);
				
				int rows = ps.executeUpdate();
				
				if (rows > 0 ) {
					System.out.println("Update successful");
					RequestDispatcher rd = request.getRequestDispatcher("LoggedInPage.jsp");
					rd.forward(request, response);
					out.print("<font color=red>Update successfully!!");
					ps.close();
					
				}else {
					out.print("Your username or password were incorrect, Please type again!");
				}
				
			}catch(ClassNotFoundException e) {e.printStackTrace();}
			catch(SQLException e) {e.printStackTrace();}
			
			
			
		}	
	}
}
