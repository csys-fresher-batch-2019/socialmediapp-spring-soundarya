<%@page import="com.soundarya.socialmedia.domain.UserList"%>
<%@page import="com.soundarya.socialmedia.factory.DAOFactory"%>
<%@page import="com.soundarya.socialmedia.domain.UserList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.soundarya.socialmedia.dao.impl.UserListImpl"%>
<%@page import="com.soundarya.socialmedia.dao.UserListDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header2.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Display User</title>
</head>

<body align="center">
	<b> <font face="Comic Sans MS">
			<h2>Search by User Email</h2>
			<form action="displayuser.jsp" method="post">

				<b>Enter the email:</b><input type="email" name="email" required /><br>
				<br> <input type="submit" name="submit" value="Display" />

			</form>
			<form action="displayuser.jsp">
				<%
					UserList u = new UserList();
									UserListDAO us = DAOFactory.getUserListDAO();

									List<UserList> display = new ArrayList<UserList>();

									String email = request.getParameter("email");
									u.setEmail(request.getParameter("email"));
									try {
										display = us.findUser(u);
									} catch (Exception e) {
										e.printStackTrace();
									}

									if (email != null) {
										out.print("<center><h3>User's Profile</h3></center>");
										out.print(
												"<table class=table table-bordered align=center><tr><th>User Id</th><th>Profile Picture</th><th>User Name</th><th>Email</th><th>Age</th><th>Gender</th><th>DOB</th><th>City</th><th>Country</th><th>Created Date</th><th>Status</th><th>Active Status</th></tr>");

										for (UserList userListClass : display) {
											//System.out.println(userListClass.findAllPosts());
											out.print("<tr><td>" + userListClass.getUserId() + "</td><td><img src=images/"
													+ userListClass.getProfilePic() + " height='100' width='100'> </td><td>"
													+ userListClass.getUserName() + "</td><td>" + userListClass.getEmail() + "</td><td>"
													+ userListClass.getAge() + "</td><td>" + userListClass.getGender() + "</td><td>"
													+ userListClass.getDob() + "</td><td>" + userListClass.getCity() + "</td><td>"
													+ userListClass.getCountry() + "</td><td>" + userListClass.getCreatedDate() + "</td><td>"
													+ userListClass.getStatus() + "</td><td>" + userListClass.getActivestatus() + "</td></tr>");
											out.print("<br>");
										}

										out.print("</table>");
									}
				%>
			</form>
	</font></b>
</body>
</html>