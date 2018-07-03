<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete</title>
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
		height: 500px;
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
		margin-bottom: 10px;
	}

</style>
</head>
<body>
	<div class="container">
	<img id="book" src='img/book.jpg'>
		<h1>Delete Student</h1>
 		<form method = "post" action="delete">
            <div>
            <input type="text" name="firstname" size="20px" placeholder="Enter Firstname" required> <br>
            </div>
            <div>
            <input type="text" name="lastname" size="20px" placeholder="Enter Lastname" required> <br>
            </div>
            <div>
            <input type="text" name="year" size="20px" placeholder="Enter Year" required> <br>
            </div>
            <div>
            <input type="text" name="school" size="20px" placeholder="Enter School" required><br>
            </div>
            <div>
            <input type="text" name="username" size = "20px" placeholder="Enter Username" required><br>
            </div>
            <div>
            <input type="password" name= "password" size = "20px" placeholder="Enter Password" required>
            </div>
        <button type="submit">Delete Student</button>  
        </form>
    </div>
<footer></footer>
</body>
</html>