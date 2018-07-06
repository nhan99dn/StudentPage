package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class sendEmail extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get email and BASE64 encoded identifier
		HttpSession session = request.getSession();
		String email = getEmail(request,session);
		String code = getCode(request, session);
		
		
		//Set up the protocol
		String to = email;
		String pass = "Hanhnhan160315";
		String from = "nhan99dn";
		String host = "smtp.gmail.com";
		
		//Set up protocol
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", true); // added this line
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.user", "nhan99dn");
	    properties.put("mail.smtp.password", "Hanhnhan160315");
	    properties.put("mail.smtp.port", "587");
	    properties.put("mail.smtp.auth", true);

		properties.setProperty("mail.smtp.host", host);
		
		Session getSession = Session.getInstance(properties, null);
		
		
		String link = "http://localhost:8080/CrunchifyJSPServletExample/authen?email=" + email + "&code=" + code;
		
		try {
			Transport transport =  getSession.getTransport("smtp");
			MimeMessage message = new MimeMessage(getSession);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Welcome to the STUDENT PAGE!! Authorization needed!");
			message.setText("You have successfully registered STUDENT PAGE, one more thing to do to become the roster of the family :) "
					+ "Please click this link and use the encrypted code in order to authenticate the user\n"
					+ "Link: " + link);
			
			transport.connect("smtp.gmail.com", from, pass);
			transport.sendMessage(message, message.getAllRecipients());
	        System.out.println("Sent message successfully....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected String encrypt(String identifier){
		return Base64.getEncoder().encodeToString(identifier.getBytes());
	}
	
	protected String getEmail(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String userSession = session.getAttribute(username + "Session").toString();
		String email = userSession.split("!")[0];
		return email;
	}
	
	protected String getCode(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String userSession = session.getAttribute(username + "Session").toString();
		String identifier = userSession.split("!")[1];
		return encrypt(identifier);
	}
}
