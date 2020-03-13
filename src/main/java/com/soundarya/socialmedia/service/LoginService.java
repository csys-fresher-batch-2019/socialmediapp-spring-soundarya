package com.soundarya.socialmedia.service;

import com.soundarya.socialmedia.dao.LoginDAO;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ServiceConstant;
import com.soundarya.socialmedia.exception.ServiceException;
import com.soundarya.socialmedia.factory.DAOFactory;

public class LoginService {
	LoginDAO dao=DAOFactory.getLoginDAO();

	public String adminLogin(String userName,String password) throws DBException, ServiceException{
		try {
			 return dao.adminLogin(userName,password);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	public void updatePassword(String email,String oldPassword,String newPassword) throws DBException, ServiceException{
		try {
			 dao.updatePassword(email,oldPassword,newPassword);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

}
