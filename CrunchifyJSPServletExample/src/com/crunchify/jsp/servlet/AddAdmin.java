package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		Student student = new Student();
		PrintWriter out = response.getWriter();
		student.setUsername(request.getParameter("username"));
		student.setPassword(request.getParameter("password"));
		
		Admin ad_obj = new Admin();
		ad_obj.addAdmin(student.getUsername(), student.getPassword());
		
		student = Validate.checkValid(student);
		
		if(student.isValid()) {
			response.sendRedirect("admin_loggedIn.jsp");
			out.println("<font color = red>Add Admin successfully!</font>");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("addAdmin.jsp");
			out.println("<font color = red>Invalid username and password</font>");
			rd.include(request, response);
		}
	}
}
