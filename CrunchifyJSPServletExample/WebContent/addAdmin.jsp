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
		height: 230px;
	}
	.container{
		width: 650px;
		height: 350px;
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
	input{
		margin-top: 10px;
		width: 200px;
		height: 30px;
		border: none;
		font-size: 13px;
	}
	input#button:hover{
		background-color: rgb(230,190,190);
		color: white;
	}
	.container img{
		width:150px;
		height: 150px;
		border-radius: 50%;
		margin-top:-75px;
		margin-bottom: 20px;
	}
	
</style>
<title>Login</title>
</head>
<body>
	<div class="container" >
		<img src='img/book.jpg'>
		<h1>Add Admin</h1>
        <form action="addAdmin" method ="post">
            <div class="form-input">
            <input type="text" name="username" size="20px" placeholder="Enter User Name" required><br>
            </div>
            <div class="form-input">
            <input type="password" name="password" size="20px" placeholder="Enter Password" required><br>
            </div><br>
			<input id="button" type="submit" value="Add"></button>
        	</div>
        </form>
    </div>
    <footer></footer>
</body>
</html>