package com.soundarya.mediaApp.service;

import java.util.List;

import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.domain.UserList;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

public class UserListService {
	UserListDAO dao=DAOFactory.getUserListDAO();
	
	public int insertUsers(UserList u) throws ServiceException,DBException{
		try {
			return dao.insertUsers(u);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	
	List<UserList> searchByCityAndName(String a, String city) throws DBException, ServiceException{
		try {
			return dao.searchByCityAndName(a,city);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
		
	}

	int noOfUsers() throws DBException, ServiceException{
		try {
			return dao.noOfUsers();
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<UserList> displayUser(UserList u) throws DBException, ServiceException{
		try {
			return dao.displayUser(u);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	
	public String userLogin(UserList u) throws DBException, ServiceException{
		try {
			return dao.userLogin(u);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void updateActiveStatus(UserList u) throws DBException,ServiceException{
		try {
			dao.updateActiveStatus(u);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	
	}

	public void updatePassword(UserList u) throws DBException, ServiceException{
		try {
			dao.updatePassword(u);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}
	
}
