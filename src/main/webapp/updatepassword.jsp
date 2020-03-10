<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update password</title>
</head>
        <%@ include file="header2.html" %>

<%String n=(String)session.getAttribute("semail");  %>
<body align="center">
<b>
<font face="Comic Sans MS">
<h2>Update Password</h2>
<form action="UpdatePassword" method="post">

<input type="text" name="email" value="<% out.print(n);%>" hidden/><br><br>
<b>Enter the old password:</b><input type="password" name="op"/><br><br>
<b>Enter the new password:</b><input type="password" name="np"/><br><br>
<input type="submit" name="submit" value="Update"/>
</form>
</font></b>
</body>
</html>