<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crunchify.jsp.servlet.dao.StudentDao" %>
<%@ page import="com.crunchify.jsp.servlet.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style> 
	body {
		background-image: url("img/desk.jpg");
   	 	background-repeat: no-repeat;
    	background-size: cover;
    	background-height: 100%;
    	font-family: Arial, Helvetica, sans-serif;
	}
	footer{
		max-width:100%;
		height: 230px;
	}
	.container{
		width: 650px;
		height: 550px;
		text-align:center;
		background-color: rgb(51, 85, 51, 0.3);
		margin:0 auto ;
		margin-top: 150px;
	}
	form div input{
		height: 30px;
		width: 250px;
		font-size: 16px;
		margin-bottom:10px;
		border: none;
		padding-left: 20px;
	}
	input#button{
		margin-top: -10px;
		width: 150px;
		height: 20px;
		border: none;
	}
	button{
		width: 150px;
		height:30px;
		margin-top:30px;
	}
	button:hover{
		background-color: rgb(230,190,190);
		color: white;
		border: none;
	}

	div.container img#book{
		width:150px;
		height: 150px;
		border-radius: 50%;
		margin-top:-75px;
		margin-bottom: 20px;
	}

</style>
</head>
<body>
<%
	int id = 1;
	if (request.getParameter("id")!= null){
		id = Integer.parseInt(request.getParameter("id"));
	}
	StudentDao stdDao = new StudentDao();
	Student student = stdDao.getStudentById(id);
	if(student==null){
		response.sendRedirect("Login.jsp");
	}
%>
	<div class="container">
	<img id="book" src="img/book.jpg">
	<h1>Edit Student</h1>
 			<form method = "post" action="edit">
 			<strong>ID:</strong>
            <input style="border:none; margin-bottom: 10px;" type="text" name="id" size="10px" value="<%=student.getId()%>" readonly><br>
            <div>
            <input type="text" name="firstname" size="20px" placeholder="Enter New Firstname" value="<%=student.getFirstName()%>" required > <br>
            </div>
            <div>
            <input type="text" name="lastname" size="20px" placeholder="Enter New Lastname" value="<%=student.getLastName()%>" required> <br>
            </div>
            <div>
            <input type="text" name="year" size="20px" placeholder="Enter New Year" value="<%=student.getYear()%>" required> <br>
            </div>
            <div>
            <input type="text" name="school" size="20px" placeholder="Enter New School" value="<%=student.getSchool()%>" required><br>
            </div>
            <div>
            <input type="text" name="username" size = "20px" placeholder="Enter Admin Username" required><br>
            </div>
            <div>
            <input type="password" name= "password" size = "20px" placeholder="Enter Admin Password" required>
            </div>
        <button type="submit">Edit</button>  
        </form>
    </div>
<footer></footer>
</body>
</html>