<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivate account</title>
</head>
<%@ include file="header2.html"%>


<body align="center">
	<b> <font face="Comic Sans MS">
			<h2>Deactivate account</h2> <br><br>
			<form action="DeactivateAccount" method="post">
				Enter your user name:<input type="text" name="name" required /><br>
				<br>
				<button onclick="myFunction()">Deactivate my account</button>
			</form> 
			<script>
				function myFunction() {
					confirm("Do you want to deactivate your account?");
				}
			</script>
	</font></b>
</body>
</html>