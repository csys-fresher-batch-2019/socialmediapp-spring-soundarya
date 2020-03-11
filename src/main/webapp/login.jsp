<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ include file="header.html"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<br>
<br>
<br>
<style>
.container {
	position: absolute;
	bottom: 100px;
	right: 500px;
	background-colour: white;
	margin: 20;
	width: 30%;
	border: 3px solid #000066;
	padding: 10px;
	font-family: cursive;
}
</style>

<body>
	<div class="container">

		<img src="images/loginimage.jpg" alt="login image" height=100%
			width=100% />
		<center>
			<h2>LOGIN</h2>
		</center>

		<form action="LoginServlet" method="post">
			<centre> Enter the Email:<input type="email"
				name="useremail"
				pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required />
			<br />
			<br />
			Enter the password:<input type="password" name="password" required />
			<br />
			<br />
			<center>
				<input class="btn btn-primary" type="submit" value="Login">
			</center>
			</centre>
		</form>
	</div>





</body>
</html>