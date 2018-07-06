<%@page import="com.crunchify.jsp.servlet.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style> 
	body {
		background-image: url("img/desk.jpg");
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
	a{
		text-decoration: none;
		color: black;
	}
</style>
<script>

</script>
<title>Account</title>
<%
	Student student = new Student();
	student = (Student) session.getAttribute("student");
	if(student==null){
		response.sendRedirect("Login.jsp");
	}
%>
</head>
<body>
<h1>
	Welcome administrator <% out.print(student.getFirstName() + " " + student.getLastName()) ;%>
	<br>
	<form action="logout">
	<button type="submit">Log out</button>
	<button type="submit" formaction="ViewProfile.jsp">View Profile</button>
	<button type="submit" formaction="page">View table</button>
	<button type="submit" formaction="addAdmin.jsp">Add Admin</button>
	</form>
	<button><a class="button" href="Delete.jsp?id=<%=student.getId()%>">Delete Student</a></button>
	<button><a class="button" href="Edit.jsp?id=<%=student.getId() %>">Edit Profile</a></button>
</h1>
</body>
<footer></footer>
</html>