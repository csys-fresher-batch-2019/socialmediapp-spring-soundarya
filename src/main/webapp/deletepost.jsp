<%@page import="com.soundarya.mediaApp.domain.Posts"%>
<%@page import="com.soundarya.mediaApp.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.soundarya.mediaApp.dao.impl.PostsImpl" %>
        <%@page import="com.soundarya.mediaApp.dao.PostsDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
<%
	Posts p=new Posts();
PostsDAO po=DAOFactory.getPostsDAO();

p.setPostId(Integer.parseInt(request.getParameter("postid")));
po.deletePost(p);
response.sendRedirect("myPosts.jsp");
%>

</form>
</body>
</html>