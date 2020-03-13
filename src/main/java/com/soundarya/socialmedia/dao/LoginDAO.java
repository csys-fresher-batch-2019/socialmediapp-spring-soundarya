package com.soundarya.socialmedia.dao;

import com.soundarya.socialmedia.exception.DBException;

public interface LoginDAO {

	public String adminLogin(String userName,String password) throws DBException;
	 
	public void updatePassword(String email,String oldPassword,String newPassword) throws DBException;


}
