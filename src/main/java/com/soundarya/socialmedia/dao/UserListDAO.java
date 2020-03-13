package com.soundarya.socialmedia.dao;

import java.util.List;

import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.exception.DBException;


public interface UserListDAO {

	int save(UserList insert) throws DBException;

	List<UserList> findByCityAndName(String a, String city) throws DBException;

	int countNoOfUsers() throws DBException;

	public List<UserList> findUser(UserList u) throws DBException;

	public String userLogin(UserList u) throws DBException;

	void updateActiveStatus(UserList u) throws DBException;

	public void updatePassword(UserList u) throws DBException;

}
