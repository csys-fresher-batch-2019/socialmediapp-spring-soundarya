<%@page import="com.soundarya.mediaApp.dao.LikesDAO"%>
<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.CommentsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="header2.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Count</title>
</head>
<body>
	<form action="myPost.jsp" method="post">
		<%
			int pid = Integer.parseInt(request.getParameter("id"));
			LikesDAO l = DAOFactory.getLikesDAO();
			int cnt = 0, cnt1 = 0;
			cnt = l.noOfLikes(pid);

			CommentsDAO c = DAOFactory.getCommentsDAO();
			cnt1 = c.noOfComments(pid);

			session.setAttribute("scnt", cnt);
			session.setAttribute("scnt1", cnt1);
		%>
		<center>
			<b><font size=6>
					<%
						out.print("No of Likes:" + cnt + "\n");
					%><br> <%
 	out.print("No of Comments:" + cnt1);
 %>
			</font></b>
		</center>
	</form>
</body>
</html>