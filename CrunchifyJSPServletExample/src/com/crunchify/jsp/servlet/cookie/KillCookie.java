package com.crunchify.jsp.servlet.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.crunchify.jsp.servlet.Student;

public class KillCookie {
	
	public void killCookie(HttpServletResponse response) {
		
		Cookie cUsername = new Cookie("cookUser", null);
		Cookie cPassword = new Cookie("cookPass", null);
		Cookie cRem = new Cookie("cookRem", null);
		cUsername.setMaxAge(0);
		cPassword.setMaxAge(0);
		cRem.setMaxAge(0);
		response.addCookie(cUsername);
		response.addCookie(cPassword);
		response.addCookie(cRem);
		
	}
}
