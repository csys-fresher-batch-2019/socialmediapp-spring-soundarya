package com.soundarya.mediaApp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundarya.mediaApp.dao.FriendRequestDAO;
import com.soundarya.mediaApp.domain.FriendRequest;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;

@WebServlet("/SendFriendRequestServlet")

public class SendFriendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FriendRequest f = new FriendRequest();

		HttpSession session = request.getSession();

		f.setRequestor((String) session.getAttribute("semail"));
		f.setAcceptor(request.getParameter("email"));
		FriendRequestDAO fr = DAOFactory.getFriendRequestDAO();

		try {
			fr.save(f);
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("userhome.jsp");

	}

}
