package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.exception.DBException;


public interface UserListDAO {

	int insertUsers(UserList insert) throws DBException;

	List<UserList> searchByCityAndName(String a, String city) throws DBException;

	int noOfUsers() throws DBException;

	public List<UserList> displayUser(UserList u) throws DBException;

	public String userLogin(UserList u) throws DBException;

	void updateActiveStatus(UserList u) throws DBException;

	public void updatePassword(UserList u) throws DBException;

}
