package com.soundarya.mediaApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundarya.mediaApp.dao.CommentsDAO;
import com.soundarya.mediaApp.domain.Comments;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;
@WebServlet("/CommentsServlet")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Comments c=new Comments();
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();  
		String n=(String)session.getAttribute("semail"); 
		int id=Integer.parseInt(request.getParameter("id"));
		String cmt=request.getParameter("comment");
		System.out.println(n);
		System.out.println(id);
		System.out.println(cmt);
		c.setCmtPostId(id);
		c.setCmtEmail(n);
		c.setCmts(cmt);
		CommentsDAO co=DAOFactory.getCommentsDAO();

		try {
			co.insertComments(c);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		//out.print("<script>alert(Liked this post successfully);</script>");
		response.sendRedirect("userhome.jsp");
	}

	

}
