<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.crunchify.jsp.servlet.*"%>
<%@page import="com.crunchify.jsp.servlet.dao.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
    	font-family: Arial, Helvetica, sans-serif;
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
	a{
		text-decoration: none;
		color: black;
		font-size: 17px;
	}
	a:hover{
		color: rgb(40, 135, 87);
		text-decoration: underline;
	}
	div{
		text-align: center;	
	}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table</title>
</head>
<body>
<div>
	<%
		List<Student> list = (List) request.getAttribute("studentList");
		int id = 0;
	%>
<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Year</th>
		<th>School</th>
		<th>Username</th>
		<th>Password</th>
		<th></th>
	</tr>
	<% for(Student student: list){
		%>
		<tr id="<%=id%>">
		 	<td><%=student.getFirstName()%></td>
			<td><%=student.getLastName()%></td>
			<td><%=student.getYear()%></td>
			<td><%=student.getSchool()%></td>
			<td><%=student.getUsername()%></td>
			<td><%=student.getPassword()%></td>
			<td>
				<form>
					<button formaction="Edit.jsp" type="submit" onclick="directEdit()">Edit</button>
					<button formaction="Delete.jsp" type="submit" onclick="directDelete()">Delete</button>
				</form>
			</td>
			<%id++;%>
        </tr>
		<%
	}%>
</table>
<div>
<br>
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <span><a href="page?page=${currentPage - 1}">Previous</a></span>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>	
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <span style="color: green;font-size:17px;">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <span><a href="page?page=${i}">${i}</a></span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
     
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <span><a href="page?page=${currentPage + 1}">Next</a></span>
    </c:if>
</div>
<footer></footer>
</body>
</html>