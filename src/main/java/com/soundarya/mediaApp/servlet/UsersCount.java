package com.soundarya.mediaApp.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;


@WebServlet("/UsersCount")

public class UsersCount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		PrintWriter out = response.getWriter();
    		//UserListImpl u=new UserListImpl();
    		UserListDAO us=DAOFactory.getUserListDAO();

    		 int count = 0;
			try {
				count=us.countNoOfUsers();
			} catch (DBException e) {
				e.printStackTrace();
			}
			System.out.println(count);
    		out.print("<center><h3>User's Count:"+count+"</h3></center>");
	}

}
