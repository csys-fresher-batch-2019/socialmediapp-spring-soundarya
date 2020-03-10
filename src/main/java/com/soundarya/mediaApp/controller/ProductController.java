package com.soundarya.mediaApp.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.dto.MessageDTO;
import com.soundarya.mediaApp.factory.DAOFactory;

@RestController
@RequestMapping("api")

public class ProductController {
	@GetMapping ("/RegisterUser")
	public MessageDTO  register(@RequestParam ("username")String userName,@RequestParam("useremail")String userEmail,@RequestParam("age")int age,@RequestParam("gender")String gender,@RequestParam ("dob")Date dob,@RequestParam ("city")String city,@RequestParam ("country")String country,@RequestParam ("status")String status,@RequestParam("password")String password,@RequestParam ("profilepic")String profilePic) throws Exception
	{
		MessageDTO msg=new MessageDTO();
		UserList user=new UserList();
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
		UserListDAO us=DAOFactory.getUserListDAO();
		
		int a=us.insertUsers(user);
		if(a==1)
		{
			msg.setInfoMessage("Successfully Registered");
		}
		else
		{
			msg.setInfoMessage("Registeration Failed");
		}
		return msg;
		
	}
	
	@GetMapping("/search")
	public List<UserList> searchByNameAndCity(@RequestParam ("name")String nameLike,@RequestParam ("city")String city) throws Exception{
		UserListDAO us=DAOFactory.getUserListDAO();
		List<UserList> l=new ArrayList<UserList>();
		l=us.searchByCityAndName(nameLike, city);
		return l;
	}
}
