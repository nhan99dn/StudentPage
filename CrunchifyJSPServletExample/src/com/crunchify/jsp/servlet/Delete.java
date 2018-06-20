package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		if (username.isEmpty() || password.isEmpty()) {
			 RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			 out.println("<font color=red>Please fill all the fields</font>");
			 rd.include(request, response);
		}
		else 
		{	
			try {
				
				Connection conn = DbConn.getConnection();
				
				String query = "DELETE FROM Students where "
						+ "username = ? and password = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, username);
				ps.setString(2, password);
			
				ps.executeQuery();
		
				RequestDispatcher rd = request.getRequestDispatcher("DeleteConfirmation.jsp");
				rd.forward(request, response);

				ps.close();
				conn.close();
				
			}
			catch (ClassNotFoundException e) {e.printStackTrace();}
			catch (Exception e) {e.printStackTrace();}

		}
	}

}
