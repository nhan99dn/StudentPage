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
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection conn = null;
			try
			{
				conn = DbConn.getConnection();
			} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
			Student student = new Student();
			PrintWriter out = response.getWriter();
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			
			student = Validate.checkValid(student);
			
			if(!student.isValid()) {
				RequestDispatcher rd = request.getRequestDispatcher("addAdmin.jsp");
				out.println("<font color = red>Invalid username and password, please type again!</font>");
				rd.include(request, response);
			}
			else {
				String query = "insert into admin_user(username,password) values(?,?)";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, student.getUsername());
				ps.setString(2, student.getPassword());
				int row = ps.executeUpdate();
			
				System.out.println("Update successfully!!!");
				response.sendRedirect("admin_loggedIn.jsp");
				ps.close();
				conn.close();
			}
		}
		catch(IOException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}		
	}
}