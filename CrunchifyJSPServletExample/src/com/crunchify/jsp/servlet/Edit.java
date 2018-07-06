package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		StudentDao stdDao = new StudentDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String newFirstname = request.getParameter("firstname");
		String newLastname = request.getParameter("lastname");
		String newYear = request.getParameter("year");
		String newSchool = request.getParameter("school");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		try {
			if(!stdDao.haveAdmin(username, password)) {
				RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp?id=" + id);
				out.println("<font color = red>Invalid admin username & password</font>");
				rd.include(request, response);
			}
			Connection conn = DbConn.getConnection();
			
			String query = "Update Students "
					+ "Set firstName =  ?,"
					+ "lastName = ?,"
					+ "year = ?,"
					+ "school = ?"
					+ "where id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, newFirstname);
			ps.setString(2, newLastname);
			ps.setString(3, newYear);
			ps.setString(4, newSchool);
			ps.setInt(5, id);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0 ) {
				response.sendRedirect("page?page=1");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp?id=" + id);
				out.print("<font color=red>Your username or password were incorrect, Please type again!<font>");
				rd.include(request, response);
				}
			}
			catch(ClassNotFoundException e) {e.printStackTrace();}
			catch(SQLException e) {e.printStackTrace();}
	}
}
