<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.crunchify.jsp.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	table#nat{
		width: 50%;
		background-color: rgb(190,190,190,0.5);
		font-size: 25px;
	}
	body {
		background-image: url("https://images.pexels.com/photos/1006293/pexels-photo-1006293.jpeg?cs=srgb&dl=contemporary-desk-eyeglasses-1006293.jpg&fm=jpg");
		margin: 0;
   	 	background-repeat: no-repeat;
    	background-size: cover;
    	background-height: 100%;
    	font-family: Arial, Helvetica, sans-serif;
	}
	footer{
		max-width:100%;
		height: 700px;
	}
	input.box{
		border: none;
		height: 25px;
		width: 200px;
		font-size: 20px;
	}
</style>
<script>
function myFunction() {
		var x = document.getElementById("myInput");
		if (x.type == "password") {
			x.type = "text";
		}
		else {
			x.type = "password";
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Profile</title>
</head>
<body>
<%
	Student student = new Student();
	student = (Student) session.getAttribute("student");
	
%>
<table id ="nat">
<tr>	
	<td>First Name</td>
	<td><%= student.getFirstName() %></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><%= student.getLastName() %></td>
</tr>
<tr>
	<td>Year</td>
	<td><%= student.getYear() %></td>
</tr>
<tr>
	<td>School</td>
	<td><%= student.getSchool() %></td>
</tr>
<tr>
	<td>Username</td>
	<td><%= student.getUsername() %></td>
</tr>
<tr>
	<td>Password</td>
	<td><input class="box" value = "<%= student.getPassword() %>" type="password" id ="myInput"></td>
</tr>
</table>
<input type="checkbox" onclick="myFunction()"> Show password
<footer></footer>
</body>
</html>