package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crunchify.jsp.servlet.cookie.FormCookie;
import com.crunchify.jsp.servlet.cookie.KillCookie;
import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	
		HttpSession session;
		StudentDao st = new StudentDao();
		
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		try {
			//Get username, password and checkbox
			Student student = new Student();
			student.setUsername(request.getParameter("username"));
			student.setPassword(request.getParameter("password"));
			String rememberMe = request.getParameter("rememberBox");
			
			student = Validate.checkValid(student);
	
			if(student.isValid()) {
				session = request.getSession();
				session.setAttribute("student", st.getStudent(student.getUsername()));
				
				//Make and Kill cookies
				if(rememberMe != null && rememberMe.equals("true") ) {
					FormCookie obj = new FormCookie();
					obj.createCookie(student, rememberMe, response);
					System.out.println("Created cookie of" + student.getUsername());
				}
				else {
					KillCookie obj = new KillCookie();
					obj.killCookie(response);
					System.out.println("Killed cookie of" + student.getUsername());
				}
				
				//initialize the admin user
				Admin ad_obj = new Admin();
				ad_obj.init();
				
				//Admin authorization	
				if(ad_obj.isAdmin(student.getUsername(),student.getPassword())) {
					RequestDispatcher rd = request.getRequestDispatcher("admin_loggedIn.jsp");
					rd.forward(request, response);
					System.out.println("Logged in, welcome administrator: " + student.getUsername());
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("user_LoggedIn.jsp");
					rd.forward(request, response);
					System.out.println("Logged in, welcome user: " + student.getUsername());
				}
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				out.println("<font color = red>Invalid username and password</font>");
				rd.include(request, response);
			}
		}catch (Exception e) {e.printStackTrace();}
	}
}
