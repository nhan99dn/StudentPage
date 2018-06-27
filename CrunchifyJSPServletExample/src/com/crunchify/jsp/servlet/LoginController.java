package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
		HttpSession session;
		StudentDao st = new StudentDao();
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		try {
			
			Student student = new Student();
			student.setFirstName(request.getParameter("firstname"));
			student.setLastName(request.getParameter("lastname"));
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			
			student = Validate.checkValid(student);
			
			if(student.isValid()) {
				
				session = request.getSession();
				session.setAttribute("student", st.getStudent(student.getUsername()));
				RequestDispatcher rd = request.getRequestDispatcher("LoggedInPage.jsp");
				rd.forward(request, response);
			}
			else {
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				out.println("<font color = red>Invalid username and password</font>");
				rd.include(request, response);
			}
		}catch (Exception e) {e.printStackTrace();}
	}
}
