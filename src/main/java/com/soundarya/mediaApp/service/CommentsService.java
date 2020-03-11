package com.soundarya.mediaApp.service;

import java.util.List;

import com.soundarya.mediaApp.dao.CommentsDAO;
import com.soundarya.mediaApp.domain.Comments;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

public class CommentsService {
	CommentsDAO dao=DAOFactory.getCommentsDAO();

	public void insertComments(Comments ins) throws DBException, ServiceException{
		try {
			 dao.insertComments(ins);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	public int noOfComments(int cmtPostId) throws DBException, ServiceException{
		try {
			 return dao.noOfComments(cmtPostId);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	public List<Comments> displayComments(Comments l) throws DBException, ServiceException{
		try {
			 return dao.displayComments(l);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

}
