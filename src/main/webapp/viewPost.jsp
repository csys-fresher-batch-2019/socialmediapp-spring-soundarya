<%@page import="com.soundarya.socialmedia.domain.Posts"%>
<%@page import="com.soundarya.socialmedia.factory.DAOFactory"%>
<%@page import="com.soundarya.socialmedia.dao.PostsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
        <%@page import="java.util.ArrayList" %>
        <%@page import="java.io.PrintWriter" %>
        <%@ include file="header2.html" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>View Posts</title>
</head>
<body>
<b>
<font face="Comic Sans MS">
<form action="viewPost.jsp" method="post">
<%
	PostsDAO p=DAOFactory.getPostsDAO();

List<Posts> view=new ArrayList<Posts>();
//view=p.display();
view=p.findAllPublicPosts();	

out.print("<center><h3>Posts</h3></center>");
out.print("<table class=table table-striped align=center><tr><th>Post</th><th>Details</th><th></th></tr>");

for (Posts postsClass : view) {
	
	if(postsClass.getPostType().contains(".mp4"))
	{
		out.print("<tr><td><video width='200' height='200' controls> <source src='videos/"+postsClass.getPostType()+"' type='video/mp4'></video> </td><td>ID:"+postsClass.getPostId()+"<br>Email:"+postsClass.getEmail()+"<br>caption:"+postsClass.getCaption()+"<br>Date Posted:"+postsClass.getDatePosted()+"<br><a href=Likes?pid="+postsClass.getPostId()+" ><button type=button class=btn btn-success>Like</button></a>&nbsp;&nbsp;<a href=comments.jsp  ?poid="+postsClass.getPostId()+"><button type=button class=btn btn-success>Comment</button></a></td><td><a href=sendFriendRequest.jsp?email="+postsClass.getEmail()+"><button type=button class=btn btn-success>Send Request</button></a></td></tr>");
		out.print("<br>");
	}
	//if(postsClass.getPostType().contains(".jpg")||postsClass.getPostType().contains(".jpeg")||postsClass.getPostType().contains(".png"))
	else
	{
	out.print("<tr><td><img src=images/"+postsClass.getPostType()+" height='200' width='200'> </td><td>ID:"+postsClass.getPostId()+"<br>Email:"+postsClass.getEmail()+"<br>caption:"+postsClass.getCaption()+"<br>Date Posted:"+postsClass.getDatePosted()+"<br><a href=Likes?pid="+postsClass.getPostId()+" ><button type=button class=btn btn-success>Like</button></a>&nbsp;&nbsp;<a href=comments.jsp  ?poid="+postsClass.getPostId()+"><button type=button class=btn btn-success>Comment</button></a></td><td><a href=sendFriendRequest.jsp?email="+postsClass.getEmail()+"><button type=button class=btn btn-success>Send Request</button></a></td></tr>");
	out.print("<br>");
	}
}
out.print("</table>");
%>

</form>
</font></b>
</body>
</html>