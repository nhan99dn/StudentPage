package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class HelloCrunchify
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String year = request.getParameter("year");
		String school = request.getParameter("school");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		StudentDao st= new StudentDao();
		if (firstName.isEmpty() || lastName.isEmpty() || year.isEmpty() || school.isEmpty() || username.isEmpty() || password.isEmpty()) {
			
			 RequestDispatcher toRegis = request.getRequestDispatcher("Registration.jsp");
			 out.println("<font color=red>Please fill all the fields</font>");
			 toRegis.include(request, response);
			 
		}else if(!st.checkUsename(username)) {
			 RequestDispatcher toRegis = request.getRequestDispatcher("Registration.jsp");
			 out.println("<font color = red>Your username is used. Please try again</font>");
			 toRegis.include(request,response);
		}
		else {	
			try {
				
				Connection conn = DbConn.getConnection();
				
				String query = "insert into Students(firstName,lastName,year,school,username,password) values(?,?,?,?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, year);
				ps.setString(4, school);
				ps.setString(5, username);
				ps.setString(6, password);
				
				int row = ps.executeUpdate();
				
				if (row == 0) {
					RequestDispatcher toRegis = request.getRequestDispatcher("Registration.jsp");
					out.println("<font color = red>Your username already exists!</font>");
					toRegis.include(request,response);
				}
				else {
					System.out.println("Update successfully!!!");
					ps.close();
					conn.close();
				}
			}
			catch (ClassNotFoundException e) {e.printStackTrace();}
			catch (Exception e) {e.printStackTrace();}
			
			RequestDispatcher rd = request.getRequestDispatcher("InsertConfirmation.jsp");
			rd.forward(request, response);
			
		}
	}
}
