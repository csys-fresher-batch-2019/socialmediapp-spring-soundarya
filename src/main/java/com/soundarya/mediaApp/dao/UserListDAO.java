package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.dao.impl.UserListImpl;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.exception.DBException;

//import java.util.List;
public interface UserListDAO {
	
	int insertUsers(UserList insert) throws DBException;
	
	List<UserList> searchByCityAndName(String a,String city) throws DBException;
	
	List<UserList> nameLike(String searchname) throws DBException;
	
	String[] searchByAge(int age) throws DBException;
	
	int noOfUsers() throws DBException;
	
	public List<UserList> displayUser(UserList u) throws DBException;
	
	 public String userLogin(UserList u) throws DBException;
	
	 void updateActiveStatus(UserList u) throws DBException;
	
	public void updatePassword(UserList u) throws DBException;

}
