package com.soundarya.mediaApp.service;

import com.soundarya.mediaApp.dao.LoginDAO;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

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
