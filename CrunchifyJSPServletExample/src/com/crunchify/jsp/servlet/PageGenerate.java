package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crunchify.jsp.servlet.dao.StudentDao;

/**
 * Servlet implementation class PageGenerate
 */
@WebServlet("/PageGenerate")
public class PageGenerate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 5;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		StudentDao stdDao = new StudentDao();
		try {
			List<Student> list = stdDao.getStudentBy((page - 1) * recordsPerPage, recordsPerPage);
			int numStudent = stdDao.getTotal();
			int numPage = (int) Math.ceil(numStudent * 1.0 / recordsPerPage);
			request.setAttribute("studentList" , list);
			request.setAttribute("noOfPages", numPage);
			request.setAttribute("currentPage", page);
			RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
			rd.include(request, response);
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
	}
}
