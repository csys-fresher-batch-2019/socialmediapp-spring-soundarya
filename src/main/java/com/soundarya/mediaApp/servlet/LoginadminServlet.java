package com.soundarya.mediaApp.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.mediaApp.dao.impl.LoginImpl;

@WebServlet("/LoginadminServlet")

public class LoginadminServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7039026043120313709L;

	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginImpl l=new LoginImpl();
		String loginMessage=null;
		String email1=request.getParameter("useremail1");
		System.out.println(email1);
		String password1=request.getParameter("password1");
		System.out.println(password1);
		try {
		loginMessage=l.adminLogin(email1, password1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(loginMessage.equals("success")){
			response.sendRedirect("adminhome.jsp");
		}
		else
			response.sendRedirect("index.jsp");
	
}
}