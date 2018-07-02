package com.crunchify.jsp.servlet;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	
	private static List<Student> admin_student = new ArrayList<Student>();
	
	public boolean isAdmin(String username, String password) {
		for(Student student : admin_student) {
			if(username.equals(student.getUsername().toString()) && password.equals(student.getPassword().toString())) {
				return true;
			}
		}
		return false;
	}
	
	public void addAdmin(String username, String password) {
		Student new_student = new Student();
		new_student.setUsername(username);
		new_student.setPassword(password);
		admin_student.add(new_student);
	}
	
	public void init() {
		Student student = new Student();
		student.setUsername("nhan99dn");
		student.setPassword("Hanhnhan160315");
		admin_student.add(student);
	}
	
}
