package com.soundarya.socialmedia.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.socialmedia.dao.LoginDAO;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.factory.DAOFactory;


@WebServlet("/UpdateAdminPassword")

public class UpdateAdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LoginImpl l=new LoginImpl();
		LoginDAO us=DAOFactory.getLoginDAO();

		String email=request.getParameter("email");
		String oldPassword=request.getParameter("op");
		String newPassword=request.getParameter("np");
		
		try {
			us.updatePassword(email, oldPassword, newPassword);
		} catch (DBException e) {
			e.printStackTrace();
		}
	
		response.sendRedirect("adminhome.jsp");
	}

}
