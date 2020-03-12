package com.soundarya.mediaApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundarya.mediaApp.dao.LikesDAO;
import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;

@WebServlet("/LikesServlet")

public class LikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Likes p = new Likes();
		HttpSession session = request.getSession();
		String n = (String) session.getAttribute("semail");
		int s = Integer.parseInt(request.getParameter("pid"));
		System.out.println(n);
		System.out.println(s);
		p.setLikePostId(s);
		p.setLikeEmail(n);
		LikesDAO li = DAOFactory.getLikesDAO();

		try {
			li.save(p);
		} catch (DBException e) {
			e.printStackTrace();
		}
		// out.print("<script>alert(Liked this post successfully);</script>");
		response.sendRedirect("userhome.jsp");
	}

}
