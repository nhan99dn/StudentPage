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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		
		try {
			updateAuthen(email, code);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		out.println("<font color= red>Authenticate successfully, Please login</font>");
		rd.include(request, response);
	}

	protected String decrypt(String code){
		byte[] decodeByte = Base64.getDecoder().decode(code.getBytes());
		return new String(decodeByte);
	}
	
	protected void updateAuthen(String email,String code) throws SQLException {
		String identifier = decrypt(code);
		
		Connection conn = null;
		try{
			conn = DbConn.getConnection();
		}
		catch(Exception e) {e.printStackTrace();}
		
		String query = "update Students "
				+ "Set authen = 1"
				+ " where email = ? and identifier = ? ";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, identifier);
		
		ps.executeUpdate();
	}	
}
