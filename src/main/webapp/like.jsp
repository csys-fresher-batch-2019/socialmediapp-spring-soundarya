<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.soundarya.socialmedia.dao.impl.LikesImpl"%>
<%@page import="com.soundarya.socialmedia.dao.LikesDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Likes</title>
</head>
<h2>Add Likes</h2>
<body align="center">
	<%
		String n = (String) session.getAttribute("semail");
		String s = request.getParameter("pid");
	%>
	<form action="Likes" method="get">
		Enter the post ID:<input type="number" name="id"
			value="<%out.print(s);%>" required><br>
		<br> Enter your email:<input type="email" name="email"
			value="<%out.print(n);%>" required><br>
		<br> <input type="submit" name="submit" value="Add Like">
	</form>

</body>

</html>