package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crunchify.jsp.servlet.cookie.KillCookie;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
		
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			KillCookie obj = new KillCookie();
			obj.killCookie(response);
			response.sendRedirect("Login.jsp");
			System.out.println("User have logged out");
		}catch (Exception e) {e.printStackTrace();}
	}
}
