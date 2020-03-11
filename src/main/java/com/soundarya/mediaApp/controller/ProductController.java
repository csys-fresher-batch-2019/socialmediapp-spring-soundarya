package com.soundarya.mediaApp.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soundarya.mediaApp.dao.FriendRequestDAO;
import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.domain.FriendRequest;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.dto.MessageDTO;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.factory.DAOFactory;

@RestController
@RequestMapping("api")

public class ProductController {
	@GetMapping("/RegisterUser")
	public MessageDTO register(@RequestParam("username") String userName, @RequestParam("useremail") String userEmail,
			@RequestParam("age") int age, @RequestParam("gender") String gender, @RequestParam("dob") Date dob,
			@RequestParam("city") String city, @RequestParam("country") String country,
			@RequestParam("status") String status, @RequestParam("password") String password,
			@RequestParam("profilepic") String profilePic) throws Exception {
		MessageDTO msg = new MessageDTO();
		UserList user = new UserList();
		user.setUserName(userName);
		user.setEmail(userEmail);
		user.setAge(age);
		user.setGender(gender);
		user.setDob(dob);
		user.setCity(city);
		user.setCountry(country);
		user.setStatus(status);
		user.setUserPassword(password);
		user.setProfilePic(profilePic);
		UserListDAO us = DAOFactory.getUserListDAO();

		int a = us.insertUsers(user);
		if (a == 1) {
			msg.setInfoMessage("Successfully Registered");
		} else {
			msg.setInfoMessage("Registeration Failed");
		}
		return msg;

	}

	@GetMapping("/search")
	public List<UserList> searchByNameAndCity(@RequestParam("name") String nameLike, @RequestParam("city") String city)
			throws Exception {
		UserListDAO us = DAOFactory.getUserListDAO();
		List<UserList> l = new ArrayList<UserList>();
		l = us.searchByCityAndName(nameLike, city);
		return l;
	}

	@GetMapping("/login")
	public MessageDTO userlogin(@RequestParam("useremail") String email, @RequestParam("password") String password)
			throws DBException {
		UserListDAO us = DAOFactory.getUserListDAO();
		MessageDTO msg = new MessageDTO();
		UserList u = new UserList();
		u.setEmail(email);
		u.setUserPassword(password);
		String res = us.userLogin(u);
		if (res.equals("success")) {
			msg.setInfoMessage("Successfully Logged In");
		} else if (res.equals("failure")) {
			msg.setInfoMessage("Login Failed");

		}
		return msg;
	}

	@GetMapping("/ViewFriendRequest")
	public List<FriendRequest> ViewFriendRequest(@RequestParam("semail") String email) throws DBException {
		FriendRequestDAO dao = DAOFactory.getFriendRequestDAO();
		List<FriendRequest> l = new ArrayList<FriendRequest>();
		l = dao.getAcceptorList(email);
		return l;
	}
}
