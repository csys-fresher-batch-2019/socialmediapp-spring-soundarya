<%@page import="com.soundarya.mediaApp.dao.CommentsDAO"%>
<%@page import="com.soundarya.mediaApp.domain.Comments"%>
<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@page import="com.soundarya.mediaApp.dao.LikesDAO"%>
<%@page import="com.soundarya.mediaApp.domain.Likes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.List" %>
        <%@page import="java.util.ArrayList" %>
        <%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>View</title>
</head>
<body>
<form action="view.jsp" method="post">
<%
	Likes dis=new Likes();
List<Likes> list = new ArrayList<Likes>();
LikesDAO d=DAOFactory.getLikesDAO();

dis.setLikePostId(Integer.parseInt(request.getParameter("post_id")));
list=d.findAllLikes(dis);

out.print("<div class=container><center><h3>Liked by</h3></center>");
out.print("<table class=table table-striped><thead><tr><th>Email</th><th>Time</th></tr><thead>");

for (Likes likesclass : list) {
	
		out.print("<tr><td>"+likesclass.getLikeEmail()+"</td><td>"+likesclass.getLikeDate()+"</td></tr>");
		out.print("<br>");
}
out.print("</table></div>");
out.print("<br><br>");
Comments di=new Comments();
CommentsDAO display=DAOFactory.getCommentsDAO();

List<Comments> li = new ArrayList<Comments>();
di.setCmtPostId(Integer.parseInt(request.getParameter("post_id")));
li=display.findAllComments(di);

out.print("<div class=container><center><h3>Commented by</h3></center>");
out.print("<table class=table table-striped><thead><tr><th>Email</th><th>Time</th><th>Comments</th></tr><thead>");

for (Comments commentsClass : li) {
	
		out.print("<tr><td>"+commentsClass.getCmtEmail()+"</td><td>"+commentsClass.getCmtDate()+"</td><td>"+commentsClass.getCmts()+"</td></tr>");
		out.print("<br>");
}
out.print("</table></div>");
%>

</form>
</body>
</html>