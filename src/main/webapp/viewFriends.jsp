<%@page import="com.soundarya.mediaApp.domain.FriendRequest"%>
<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.FriendRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
        <%@page import="java.util.ArrayList" %>
        <%@ include file="header2.html" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>View Friends</title>
</head>
<body align="center">
<b>
<font face="Comic Sans MS">
<h3>View Friends based on current status </h3><br>
<form action="viewFriends.jsp" method="post">
<b>Select the status:</b>
<select id="status" name="status">
    <option value="accepted">Accepted</option>
    <option value="rejected">Rejected</option>
    <option value="pending">Pending</option>
  </select><br><br>


<input type="submit" name="submit" value="View">
</form >

<form action="viewFriends.jsp" method="post">
<%
FriendRequestDAO f=DAOFactory.getFriendRequestDAO();

List<FriendRequest> view=new ArrayList<FriendRequest>();
String n=(String)session.getAttribute("semail"); 
String sts=request.getParameter("status");
try {
	view=f.getFriendrequest(n, sts);
}
catch(Exception e)
{
	e.printStackTrace();
}
if(sts!=null){
	out.print("<center><h3>List of people</h3></center>");
	out.print("<div class=container><table class=table table-bordered><thead><tr><th>Acceptor</th><th>Status</th></tr></thead>");
	
	for (FriendRequest friendRequestClass : view) {
		System.out.println(friendRequestClass.toString());
		out.print("<tbody align=left><tr><td>"+friendRequestClass.getAcceptor()+"</td><td>"+friendRequestClass.getCurrentStatus()+"</td></tr></tbody>");
		out.print("<br>");
	}
	out.print("</table></div>");
}
%></form>
</font></b>
</body>
</html>