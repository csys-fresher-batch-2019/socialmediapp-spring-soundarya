package com.soundarya.mediaApp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundarya.mediaApp.dao.PostsDAO;
import com.soundarya.mediaApp.domain.Posts;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;

@WebServlet("/DisplayFriendsPost")

public class DisplayFriendsPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostsDAO us=DAOFactory.getPostsDAO();

		PrintWriter out = response.getWriter();
		List<Posts> dis=new ArrayList<Posts>();
		HttpSession session=request.getSession();
		String n=(String)session.getAttribute("semail");
		out.print(n);
		try {
			dis=us.findAllFriendsPosts(n);
		} catch (DBException e) {
			e.printStackTrace();
		}
		for (Posts postsClass : dis) {
			out.print(postsClass);
		}
		
		

		/*out.print("<center><h3>Posts</h3></center>");
		out.print("<table border=1 align=center><tr><th>Post</th><th>Details</th></tr>");
		
		for (PostsClass postsClass : dis) {
			if(postsClass.getPostType().contains(".jpg")||)
			{
			out.print("<tr><td><img src=images/"+postsClass.getPostType()+" height='200' width='200'> </td><td>ID:"+postsClass.getPostId()+"<br>Email:"+postsClass.getEmail()+"<br>caption:"+postsClass.getCaption()+"<br>Date Posted:"+postsClass.getDatePosted()+"</td></tr>");
			out.print("<br>");
			}
			else if(postsClass.getPostType().contains(".mp4"))
			{
				out.print("<tr><td><video width='200' height='200' controls> <source src='videos/"+postsClass.getPostType()+"' type='video/mp4'></video> </td><td>ID:"+postsClass.getPostId()+"<br>Email:"+postsClass.getEmail()+"<br>caption:"+postsClass.getCaption()+"<br>Date Posted:"+postsClass.getDatePosted()+"</td></tr>");
				out.print("<br>");
			}
		}
		
		out.print("</table>");*/
	}

}
