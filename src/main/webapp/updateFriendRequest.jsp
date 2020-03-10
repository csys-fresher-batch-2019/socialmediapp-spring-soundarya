<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.FriendRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file="header2.html" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update friend request</title>
</head>
<body align="center">
<b>
<font face="Comic Sans MS">
<h2>Update friend request</h2>
<form action="updateFriendRequest.jsp" method="post">
<%
	String n=(String)session.getAttribute("semail"); 
String r=request.getParameter("up");
%>

<input type="email" name="acp" value="<%out.print(n);%>"required hidden/><br><br>
<input type="email" name="req" value="<%out.print(r);%>" required hidden><br><br>
Select the status updation(accepted/rejected):
<select id="sts" name="sts">
    <option value="accepted">Accept</option>
    <option value="rejected">Reject</option>
    <option value="pending">Keep Pending</option>
  </select><br><br>
<input type="submit" name="submit" value="Update">
</form>
<form action="updateFriendRequest.jsp" method="post">
<%
FriendRequestDAO u=DAOFactory.getFriendRequestDAO();
  String acp=request.getParameter("acp");
  String req=request.getParameter("req");
  String sts=request.getParameter("sts");
  u.updateStatus(sts,req,acp);
%>
 
</form>
</font></b>
</body>

</html>