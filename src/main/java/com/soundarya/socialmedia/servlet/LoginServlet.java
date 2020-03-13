package com.soundarya.socialmedia.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.factory.DAOFactory;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserListDAO us=DAOFactory.getUserListDAO();
		UserList u=new UserList();
		
		String loginMessage=null;
		
		u.setEmail(request.getParameter("useremail"));
		u.setUserPassword(request.getParameter("password"));
		HttpSession session=request.getSession();
		String email=request.getParameter("useremail");
	    session.setAttribute("semail",email);  
	     //response.sendRedirect("userhome.jsp");
		try {
		loginMessage=us.userLogin(u);
		//System.out.println(loginMessage);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(loginMessage.equals("success"))
			response.sendRedirect("userhome.jsp");
		else
			response.sendRedirect("index.jsp");
		
		
	}

	
}
