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
	//getStudent by username, check availability of Student by Username
	public Student getStudentByUserName(String username) throws ClassNotFoundException, SQLException {
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
			s.setYear(rs.getString("year"));
			s.setUsername(rs.getString("username"));
			s.setSchool(rs.getString("school"));
			s.setPassword(rs.getString("password"));
			s.setEmail(rs.getString("email"));
			return s;
		}
		return null;
	}
	
	//get Student by Id
	public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM students WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setFirstName(rs.getString("firstName"));
			s.setLastName(rs.getString("lastName"));
			s.setYear(rs.getString("year"));
			s.setUsername(rs.getString("username"));
			s.setSchool(rs.getString("school"));
			s.setPassword(rs.getString("password"));
			s.setEmail(rs.getString("email"));
			return s;
		}
		return null;
	}
	//getAdmin by username, check availability
	public boolean haveAdmin(String username, String password) throws ClassNotFoundException, SQLException {
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM admin_user WHERE username =? and password = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}

	//Get Student by Offset, Limit
	public List<Student> getStudentBy(int offset, int limit) throws ClassNotFoundException, SQLException{
		Connection con = DbConn.getConnection();
		String sql = "SELECT * FROM students limit ?, ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, offset);
		ps.setInt(2, limit);
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setFirstName(rs.getString("firstName"));
			s.setLastName(rs.getString("lastName"));
			s.setYear(rs.getString("year"));
			s.setUsername(rs.getString("username"));
			s.setSchool(rs.getString("school"));
			s.setPassword(rs.getString("password"));
			s.setAuthen(rs.getBoolean("authen"));
			list.add(s);
		}
		return list;
	}
	
	//Get the total of Students
	public int getTotal() throws ClassNotFoundException, SQLException{
		List<Student> list = this.getStudentBy(0, 10000);
		int total =  list.size();
		return total;
	} 
}
