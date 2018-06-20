<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		margin-bottom: 50px;
	}
</style>
</head>
<body>
<div class="container" >
	<img id="book" src='https://images.pexels.com/photos/373465/pexels-photo-373465.jpeg?cs=srgb&dl=blur-book-girl-373465.jpg&fm=jpg'>
        <form action="insert" method ="post">
            <div class="form-input">
            <input type="text" name="firstname" size="20px" placeholder="Enter First Name"> <br>
            </div>
            <div class="form-input">
            <input class = type="text" name="lastname" size="20px" placeholder="Enter Last Name"> <br>
            </div>
            <div class="form-input">
            <input type="text" name="year" size="20px" placeholder="Enter Year"> <br>
            </div>
            <div class="form-input">
            <input type="text" name="school" size="20px" placeholder="Enter School"><br>
            </div>
            <div class="form-input">
            <input type="text" name="username" size = "20px" placeholder="Enter username"><br>
            </div>
            <div class="form-input">
            <input type="password" name= "password" size = "20px" placeholder="Enter password">
            </div>
        <button type="submit">Register Student</button>
        </form>
    </div>
<footer></footer>
</body>
</html>