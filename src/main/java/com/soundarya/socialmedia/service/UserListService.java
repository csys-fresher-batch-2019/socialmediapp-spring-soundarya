package com.soundarya.socialmedia.service;

import java.util.List;

import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.domain.UserList;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ServiceConstant;
import com.soundarya.socialmedia.exception.ServiceException;
import com.soundarya.socialmedia.factory.DAOFactory;

public class UserListService {
	UserListDAO dao=DAOFactory.getUserListDAO();
	
	public int save(UserList u) throws ServiceException,DBException{
		try {
			return dao.save(u);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	
	List<UserList> findByCityAndName(String a, String city) throws DBException, ServiceException{
		try {
			return dao.findByCityAndName(a,city);
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
		
	}

	int countNoOfUsers() throws DBException, ServiceException{
		try {
			return dao.countNoOfUsers();
		}
		catch(DBException e)
		{
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<UserList> findUser(UserList u) throws DBException, ServiceException{
		try {
			return dao.findUser(u);
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
