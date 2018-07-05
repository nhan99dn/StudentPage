package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class authen
 */
@WebServlet("/authen")
public class authen extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String code = request.getParameter("code");
		
		try {
			if(checkEmail(username,request,response)) {
				RequestDispatcher rd = request.getRequestDispatcher("authen.jsp");
				out.println("<font color = red>Your username was incorrect!</font>");
				rd.include(request, response);
			}
			else {
				HttpSession session = request.getSession();
				String decoded = decrypt(code);
				final String IDENTIFIER = session.getAttribute(username + "Session").toString().split("!")[1];
				if(!(decoded.equals(IDENTIFIER))) {
					RequestDispatcher rd = request.getRequestDispatcher("authen.jsp");
					out.println("<font color = red>Your code was incorrect, please check again the retry!</font>");
					rd.include(request, response);
				}
				else {
					updateAuthen(username, true);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					out.println("<font color = red>Authenticated successfully</font>");
					rd.include(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected boolean checkEmail(String username, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		Connection conn = null;
		try{
			conn = DbConn.getConnection();
		}
		catch(Exception e) {e.printStackTrace();}
		
		String query = "Select * from Students where username = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		boolean more = rs.next();
		if(more) {
			return false;
		}
		return true;
	}
	
	protected String decrypt(String code){
		byte[] decodeByte = Base64.getDecoder().decode(code.getBytes());
		return new String(decodeByte);
	}
	
	protected void updateAuthen(String username, boolean authen) throws SQLException {
		int numBool = 0;
		if(authen) {
			numBool = 1;
		}
		
		Connection conn = null;
		try{
			conn = DbConn.getConnection();
		}
		catch(Exception e) {e.printStackTrace();}
		
		String query = "update Students "
				+ "Set authen = ? where username = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, numBool);
		ps.setString(2, username);
		
		try {
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
