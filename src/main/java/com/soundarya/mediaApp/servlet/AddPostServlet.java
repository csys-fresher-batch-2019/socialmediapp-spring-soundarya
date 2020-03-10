package com.soundarya.mediaApp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.mediaApp.dao.PostsDAO;
import com.soundarya.mediaApp.domain.Posts;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;

@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Posts p=new Posts();
		
		p.setEmail(request.getParameter("requestor"));
		p.setPostType(request.getParameter("postType"));
		p.setCaption(request.getParameter("caption"));
		p.setViewability(request.getParameter("viewability"));
		PostsDAO po=DAOFactory.getPostsDAO();

		try {
			po.addPosts(p);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.sendRedirect("userhome.jsp");
	}

}
