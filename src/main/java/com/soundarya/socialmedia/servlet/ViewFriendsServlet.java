package com.soundarya.socialmedia.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.socialmedia.dao.FriendRequestDAO;
import com.soundarya.socialmedia.domain.FriendRequest;
import com.soundarya.socialmedia.factory.DAOFactory;

@WebServlet("/ViewFriendsServlet")

public class ViewFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FriendRequest> view=new ArrayList<FriendRequest>();
		
		String req=request.getParameter("requestor");
		System.out.println(req);
		String sts=request.getParameter("status");
		FriendRequestDAO fr=DAOFactory.getFriendRequestDAO();

		try {
			view=fr.findFriendrequest(req, sts);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.print("<center><h3>List of people</h3></center>");
		out.print("<table border=1 align=center><tr><th>Acceptor and Status</th></tr>");
		
		for (FriendRequest friendRequestClass : view) {
			System.out.println(friendRequestClass.toString());
			out.print("<tr><td> Email:"+friendRequestClass.getAcceptor()+"<br>Status"+friendRequestClass.getCurrentStatus()+"</td></tr>");
			out.print("<br>");
		}
		out.print("</table>");

	}

}
