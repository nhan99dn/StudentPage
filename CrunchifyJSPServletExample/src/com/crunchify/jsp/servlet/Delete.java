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

import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		StudentDao stdDao = new StudentDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		try {
			if (!stdDao.haveAdmin(username, password)) {
				 RequestDispatcher rd = request.getRequestDispatcher("Delete.jsp?id=" + id);
				 out.println("<font color=red>Wrong admin username and password</font>");
				 rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		try {		
		conn = DbConn.getConnection();
			
		String sql = "DELETE FROM Students where "
				+ "id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
				
		ps.setInt(1, id);
		
		ps.executeUpdate();

		response.sendRedirect("page?page=1");

		ps.close();
		conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
