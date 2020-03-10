package com.soundarya.mediaApp.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;


@WebServlet("/RegisterUserServlet")

public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserList u=new UserList();
    	 
    	 u.setUserName(request.getParameter("username"));
		//System.out.println(name);
		u.setEmail(request.getParameter("useremail"));
		u.setAge(Integer.parseInt(request.getParameter("age")));
		//u.setAge(request.getParameter("age"));
		u.setGender(request.getParameter("gender"));
		u.setDob(java.sql.Date.valueOf(request.getParameter("dob")));
		u.setCity(request.getParameter("city"));
		u.setCountry(request.getParameter("country"));
		u.setStatus(request.getParameter("status"));
		u.setUserPassword(request.getParameter("password"));
		u.setProfilePic(request.getParameter("profilepic"));
		UserListDAO us=DAOFactory.getUserListDAO();
			try {
				us.insertUsers(u);
			} catch (DBException e) {
				e.printStackTrace();
			}
			response.sendRedirect("login.jsp");
	}
}
