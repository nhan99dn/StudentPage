package com.crunchify.jsp.servlet.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.crunchify.jsp.servlet.Student;

public class FormCookie {
	
	public void createCookie(Student student, String rememberMe, HttpServletResponse response) {
		
		Cookie cUsername = new Cookie("cookUser", student.getUsername());
		Cookie cPassword = new Cookie("cookPass", student.getPassword());
		Cookie cRem = new Cookie("cookRem", rememberMe);
		cUsername.setMaxAge(60*60*24*365);
		cPassword.setMaxAge(60*60*24*365);
		cRem.setMaxAge(60*60*24*365);
		response.addCookie(cUsername);
		response.addCookie(cPassword);
		response.addCookie(cRem);
		
	}
}
