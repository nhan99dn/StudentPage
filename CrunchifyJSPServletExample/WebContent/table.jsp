<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.crunchify.jsp.servlet.*"%>
<%@page import="com.crunchify.jsp.servlet.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style media="screen">
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
	}
    table{
		width: 100%;
		background-color: rgb(190,190,190,0.2);
	}

	th,td {
		text-align: center;
		padding: 10px;
	}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table</title>
</head>
<body>
<div>
<table>
<% 
	List<Student> list = new ArrayList<Student>();
	list = StudentDao.getAll();
%>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Year</th>
		<th>School</th>
		<th>Username</th>
		<th>Password</th>
		<th></th>
	</tr>
	<%for (Student s: list){
		%>
		<tr>
			<td><%= s.getFirstName() %></td>
			<td><%= s.getLastName() %></td>
			<td><%= s.getYear() %></td>
			<td><%= s.getSchool() %></td>
			<td><%= s.getUsername() %></td>
			<td><%= s.getPassword() %></td>
			<td><form><button formaction="Edit.jsp" type="submit">Edit</button><button formaction="Delete.jsp" type="submit">Delete</button></td>
		</tr>	
		<%
	} %>
</table>
<footer></footer>
</body>
</html>