package com.soundarya.mediaApp.service;

import java.util.List;

import com.soundarya.mediaApp.dao.FriendRequestDAO;
import com.soundarya.mediaApp.domain.FriendRequest;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

public class FriendRequestService {
	FriendRequestDAO dao=DAOFactory.getFriendRequestDAO();

	void insertRequest(FriendRequest ins) throws DBException, ServiceException{
		try {
			 dao.insertRequest(ins);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	List<FriendRequest> getFriendrequest(String requestor, String s) throws DBException, ServiceException{
		try {
			 return dao.getFriendrequest(requestor,s);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<FriendRequest> getRequestorList(String requestor) throws DBException, ServiceException
	{
		try {
			 return dao.getRequestorList(requestor);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<FriendRequest> getAcceptorList(String requestor) throws DBException, ServiceException{
		try {
			 return dao.getAcceptorList(requestor);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	void updateStatus(String currentStatus, String requestor, String acceptor) throws DBException, ServiceException{
		try {
			dao.updateStatus(currentStatus, requestor,acceptor);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}


}
