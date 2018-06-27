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
		margin-bottom: 20px;
	}

</style>
</head>
<body>
	<div class="container">
	<img id="book" src='https://images.pexels.com/photos/373465/pexels-photo-373465.jpeg?cs=srgb&dl=blur-book-girl-373465.jpg&fm=jpg'>
	<h1>Edit Student</h1>
 		<form method = "post" action="Edit">
            <div>
            <input type="text" name="firstname" size="20px" placeholder="Enter New Firstname"> <br>
            </div>
            <div>
            <input type="text" name="lastname" size="20px" placeholder="Enter New Lastname"> <br>
            </div>
            <div>
            <input type="text" name="year" size="20px" placeholder="Enter New Year"> <br>
            </div>
            <div>
            <input type="text" name="school" size="20px" placeholder="Enter New School"><br>
            </div>
            <div>
            <input type="text" name="username" size = "20px" placeholder="Enter Username"><br>
            </div>
            <div>
            <input type="password" name= "password" size = "20px" placeholder="Enter Password">
            </div>
        <button type="submit">Edit</button>  
        </form>
    </div>
<footer></footer>
</body>
</html>