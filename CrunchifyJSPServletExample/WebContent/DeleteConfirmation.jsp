<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
	body {
		background-image: url("https://images.pexels.com/photos/1006293/pexels-photo-1006293.jpeg?cs=srgb&dl=contemporary-desk-eyeglasses-1006293.jpg&fm=jpg");
		margin: 0;
   	 	background-repeat: no-repeat;
    	background-size: cover;
    	background-height: 100%;
	}
	footer{
		max-width:100%;
		height: 700px;
</style>
</head>
<body>  
<% 
	String username = request.getParameter("username");	
%>
<h1>Delete Successful</h1>
<h2> User name: 
<%
	out.print(username);
%>
</h2>
<br>
<button><a href = "table.jsp" style = "text-decoration:none; color:black">show tables</button>
<footer></footer>
</body>
</html>