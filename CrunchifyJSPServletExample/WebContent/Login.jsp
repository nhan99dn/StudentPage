<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style> 
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
	input#button{
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
	<%
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		String remember = "";
		if (cookies != null){
			for (Cookie ck : cookies){
				if(ck.getName().equals("cookUser")){
					username = ck.getValue();
				}
				if(ck.getName().equals("cookPass")){
					password = ck.getValue();
				}
				if(ck.getName().equals("cookRem")){
					remember = ck.getValue();
				}
			}
		}
	%>
	<div class="container" >
		<img src='https://images.pexels.com/photos/373465/pexels-photo-373465.jpeg?cs=srgb&dl=blur-book-girl-373465.jpg&fm=jpg'>
		<h1>Login</h1>
        <form action="login" method ="post">
            <div class="form-input">
            <input type="text" name="username" size="20px" placeholder="Enter User Name" value="<%=username%>"><br>
            </div>
            <div class="form-input">
            <input type="password" name="password" size="20px" placeholder="Enter Password" value="<%=password%>"><br>
            </div>
            <label>
        		<input type="checkbox" name="rememberBox" id="checkbox" value="true" checked ='<%=("true".equals(remember) ? "checked" : "")%>'> Remember me 
     	 	</label><br>
        	<input id="button" type="submit" value="Log in">
        	<input id="button" type="submit" formaction= "Registration.jsp" value="Dont't have account? Register!">
        	</div>
        </form>
    </div>
    <footer></footer>
</body>
</html>