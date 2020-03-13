package com.soundarya.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soundarya.socialmedia.dao.FriendRequestDAO;
import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.FriendRequest;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.dto.MessageDTO;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ErrorConstant;
import com.soundarya.socialmedia.factory.DAOFactory;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")

public class ProductController {
	@PostMapping("/RegisterUser")
	/*
	 * public MessageDTO register(@RequestParam("username") String
	 * userName, @RequestParam("useremail") String userEmail,
	 * 
	 * @RequestParam("age") int age, @RequestParam("gender") String
	 * gender, @RequestParam("dob") String dob,
	 * 
	 * @RequestParam("city") String city, @RequestParam("country") String country,
	 * 
	 * @RequestParam("status") String status, @RequestParam("password") String
	 * password,
	 * 
	 * @RequestParam("profilepic") String profilePic) throws Exception {
	 */

	public MessageDTO register(@RequestBody UserList user) {
		MessageDTO msg = new MessageDTO();
		/*
		 * UserList user = new UserList(); user.setUserName(userName);
		 * user.setEmail(userEmail); user.setAge(age); user.setGender(gender);
		 * user.setDob(LocalDate.parse(dob)); user.setCity(city);
		 * user.setCountry(country);
		 * 
		 * user.setStatus(status); user.setUserPassword(password);
		 * user.setProfilePic(profilePic); sysout
		 */
		System.out.println(user);
		UserListDAO us = DAOFactory.getUserListDAO();

		int a = 0;
		try {
			a = us.save(user);
		} catch (DBException e) {
			try {
				throw new DBException(ErrorConstant.INVALID_ADD);
			} catch (DBException e1) {
				e1.printStackTrace();
			}
		}
		if (a == 1) {
			msg.setInfoMessage("Successfully Registered");
		} else {
			msg.setInfoMessage("Registeration Failed");
		}
		return msg;

	}

	@GetMapping("/search")
	public List<UserList> searchByNameAndCity(@RequestParam("name") String nameLike, @RequestParam("city") String city)
			throws DBException {
		UserListDAO us = DAOFactory.getUserListDAO();
		List<UserList> l = new ArrayList<UserList>();
		try {
			l = us.findByCityAndName(nameLike, city);
		} catch (DBException e) {
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
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
		String res;
		try {
			res = us.userLogin(u);
		} catch (DBException e) {
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
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
		try {
			l = dao.findAcceptorList(email);
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return l;
	}
}
