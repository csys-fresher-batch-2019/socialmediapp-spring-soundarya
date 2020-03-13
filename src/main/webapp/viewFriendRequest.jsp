<%@page import="com.soundarya.socialmedia.domain.FriendRequest"%>
<%@page import="com.soundarya.socialmedia.factory.DAOFactory"%>
<%@page import="com.soundarya.socialmedia.dao.FriendRequestDAO"%>
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
<title>View Friend Request</title>
</head>
<body align="center">
<b>
<font face="Comic Sans MS">
<form action="viewFriendRequest.jsp" method="post">
<%
	String acp=(String)session.getAttribute("semail");

FriendRequestDAO f=DAOFactory.getFriendRequestDAO();

List<FriendRequest> view=new ArrayList<FriendRequest>();
//(String)session.getAttribute("semail")
//String acceptor=request.getParameter("acceptor");
try {
	view=f.findAcceptorList(acp);
}
catch(Exception e)
{
	e.printStackTrace();
}
out.print("<center><h3>List of people</h3></center>");
out.print("<div class=container><table class=table table-hover ><thead><tr><th>Request from</th><th>Status</th><th>Update</th></tr></thead>");

for (FriendRequest friendRequestClass : view) {
	System.out.println(friendRequestClass.toString());
	out.print("<tbody align=left><tr><td>"+friendRequestClass.getRequestor()+"</td><td>"+friendRequestClass.getCurrentStatus()+"</td><td><a href=updateFriendRequest.jsp?up="+friendRequestClass.getRequestor()+">Update Request</a></td></tr></tbody>");
	out.print("<br>");
}
out.print("</table></div>");
%>
</form>
</font></b>
</body>
</html>

