<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.UserListDAO"%>
<%@page import="com.soundarya.mediaApp.domain.UserList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<style>
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #51c6f0;
  color: white;
}
</style>

</head>
<body>
<div class="topnav">
  <a class="active" href="#home">AdminHome</a>
  <a href="displayuser.jsp">DisplayUser</a>
  <a href="updateadminpassword.jsp">Update Password</a>
  <a href="index.jsp">Logout</a>
  <image src="images/simage.jpg" align="right" width="50px">
</div>
<br>
<br>
<br>

<form action="adminhome.jsp" method="post" align="center">
<%

UserListDAO u=DAOFactory.getUserListDAO();
int count = 0;
count=u.noOfUsers();
System.out.println(count);
out.print("<center><h3>Number of Users:"+count+"</h3></center>");
%>

</form>
</body>
</html>