package com.soundarya.socialmedia.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.factory.DAOFactory;

@WebServlet("/UpdatePassword")

public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UserListImpl u=new UserListImpl();
		UserListDAO us=DAOFactory.getUserListDAO();
		UserList u=new UserList();

		u.setEmail(request.getParameter("email"));
		u.setUserPassword(request.getParameter("op"));
		u.setUserPassword(request.getParameter("np"));
		
		try {
			us.updatePassword(u);
		} catch (DBException e) {
			e.printStackTrace();
		}
	
		response.sendRedirect("userhome.jsp");


		
	}

}
