<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.FriendRequestDAO"%>
<%@page import="com.soundarya.mediaApp.domain.FriendRequest"%>
<%@page import="com.soundarya.socialmedia.factory.DAOFactory"%>
<%@page import="com.soundarya.socialmedia.domain.FriendRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.soundarya.socialmedia.dao.impl.FriendRequestImpl" %>
        <%@page import="com.soundarya.socialmedia.dao.FriendRequestDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Friend Request</title>
</head>
<body align="center">
<h3>Send Friend Request to your Favourite Person</h3><br>

<form action="sendFriendRequest.jsp" method="post">
<%
	FriendRequest f=new FriendRequest();
	FriendRequestDAO fr=DAOFactory.getFriendRequestDAO();

f.setRequestor((String)session.getAttribute("semail"));
f.setAcceptor(request.getParameter("email"));

fr.save(f);
response.sendRedirect("userhome.jsp");
%>
</form>
</body>
</html>