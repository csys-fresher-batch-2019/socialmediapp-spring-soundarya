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

@WebServlet("/DeactivateAccount")

public class DeactivateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserList u=new UserList();
		UserListDAO us=DAOFactory.getUserListDAO();
		u.setUserName(request.getParameter("name"));
		try {
			us.updateActiveStatus(u);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.sendRedirect("userhome.jsp");
		
		
	}

}
