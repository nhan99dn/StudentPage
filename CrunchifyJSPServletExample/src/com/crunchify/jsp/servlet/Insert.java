package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String password_again = request.getParameter("password_again");
		String email = request.getParameter("email");
		String identifier = generate();
		
		PrintWriter out = response.getWriter();
		StudentDao st = new StudentDao();
		
		if (!(password.equals(password_again))) {
			 RequestDispatcher toRegis = request.getRequestDispatcher("Registration.jsp");
			 out.println("<font color=red>Passwords mismatched.</font>");
			 toRegis.include(request, response);
		}
		
		else
			try {
				if(st.getStudentByUserName(username) != null ) {
					 RequestDispatcher toRegis = request.getRequestDispatcher("Registration.jsp");
					 out.println("<font color = red>Your username is used. Please try again</font>");
					 toRegis.include(request,response);
				}
				else {	
					try {
						Connection conn = DbConn.getConnection();
						
						String query = "insert into Students(firstName,lastName,year,school,username,password,email,identifier) values(?,?,?,?,?,?,?,?)";
						
						PreparedStatement ps = conn.prepareStatement(query);
						
						ps.setString(1, firstName);
						ps.setString(2, lastName);
						ps.setString(3, year);
						ps.setString(4, school);
						ps.setString(5, username);
						ps.setString(6, password);
						ps.setString(7, email);
						ps.setString(8, identifier);
						
						int row = ps.executeUpdate();
						
						//set Session for each user format: sessionName: username + "Session", info: email@indentifier
						HttpSession session = request.getSession();
						session.setAttribute("" + username + "Session", email +  "!" + identifier);
						
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
					
					//send Email
					sendEmail obj = new sendEmail();
					obj.doPost(request, response);
					
					RequestDispatcher rd = request.getRequestDispatcher("InsertConfirmation.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();	}
	}

	public static String generate() {
		return UUID.randomUUID().toString();
	}
	
	public static boolean emailIsValid(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	protected String encrypt(String identifier){
		return Base64.getEncoder().encodeToString(identifier.getBytes());
	}
}
