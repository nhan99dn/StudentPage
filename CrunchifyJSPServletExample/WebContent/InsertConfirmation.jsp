<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
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
</head>
<body>  
<% 
	String firstName =  request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String year = request.getParameter("year");
	String school = request.getParameter("school");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
%>
<table id ="nat">
<tr>
	<td>First Name</td>
	<td><%= firstName %></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><%= lastName %></td>
</tr>
<tr>
	<td>Year</td>
	<td><%= year %></td>
</tr>
<tr>
	<td>School</td>
	<td><%= school %></td>
</tr>
<tr>
	<td>Username</td>
	<td><%= username %></td>
</tr>
<tr>
	<td>Password</td>
	<td><input class="box" value= "<%= password %>" type="password" id ="myInput"></td>
</tr>
</table>
<input type="checkbox" onclick="myFunction()"> Show password
<br>
use " <i> select * from student; </i> " in mysql client to verify it.<br>
<form action="Login.jsp">
<button type="submit">Log in</button>
</form>
<footer></footer>
</body>
</html>