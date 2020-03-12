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

	void save(FriendRequest ins) throws DBException, ServiceException{
		try {
			 dao.save(ins);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	List<FriendRequest> findFriendrequest(String requestor, String s) throws DBException, ServiceException{
		try {
			 return dao.findFriendrequest(requestor,s);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<FriendRequest> findRequestorList(String requestor) throws DBException, ServiceException
	{
		try {
			 return dao.findRequestorList(requestor);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<FriendRequest> findAcceptorList(String requestor) throws DBException, ServiceException{
		try {
			 return dao.findAcceptorList(requestor);
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
