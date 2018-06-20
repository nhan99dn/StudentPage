package com.crunchify.jsp.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crunchify.jsp.servlet.DbConn;
import com.crunchify.jsp.servlet.Student;

public class StudentDao {
	public Student getStudent(String username) throws ClassNotFoundException, SQLException {
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM students WHERE username =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setFirstName(rs.getString("firstName"));
			s.setLastName(rs.getString("lastName"));
			s.setYear(rs.getInt("year"));
			s.setUsername(rs.getString("username"));
			s.setSchool(rs.getString("school"));
			s.setPassword(rs.getString("password"));
			return s;
		}
		return null;
	}
	public static List<Student> getAll() throws ClassNotFoundException, SQLException{
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM students";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setFirstName(rs.getString("firstName"));
			s.setLastName(rs.getString("lastName"));
			s.setYear(rs.getInt("year"));
			s.setUsername(rs.getString("username"));
			s.setSchool(rs.getString("school"));
			s.setPassword(rs.getString("password"));
			list.add(s);
		}
		return list;
	}
	public boolean checkUsename(String username){
		try {
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM students WHERE username = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
		}catch(Exception ex) {
			
			return false;
		}
	}
}
