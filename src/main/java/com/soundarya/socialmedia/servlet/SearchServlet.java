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

import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.factory.DAOFactory;

@WebServlet("/SearchServlet")

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<UserList> search = new ArrayList<UserList>();

		String name = request.getParameter("name");
		String city = request.getParameter("city");
		UserListDAO us = DAOFactory.getUserListDAO();

		try {
			search = us.findByCityAndName(name, city);

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.print("<table border=5 cellpadding=10 align=center><tr><th>Profile Picture</th><th>Details</th>");
		for (UserList userListClass : search) {
			out.print("<tr><td><img src=images/" + userListClass.getProfilePic()
					+ " height='100' width='100'> </td><td>Name:" + userListClass.getUserName() + "<br>Email:"
					+ userListClass.getEmail() + "<br>Age:" + userListClass.getAge() + "<br>Gender:"
					+ userListClass.getGender() + "</td><td><a href=sendFriendRequest.jsp?email="
					+ userListClass.getEmail() + ">Send Friend Request</a></td></tr>");
			out.print("<br>");
		}
		out.print("</table>");

	}
}
