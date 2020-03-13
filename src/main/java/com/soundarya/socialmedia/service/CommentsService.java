package com.soundarya.socialmedia.service;

import java.util.List;

import com.soundarya.socialmedia.dao.CommentsDAO;
import com.soundarya.socialmedia.domain.Comments;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ServiceConstant;
import com.soundarya.socialmedia.exception.ServiceException;
import com.soundarya.socialmedia.factory.DAOFactory;

public class CommentsService {
	CommentsDAO dao=DAOFactory.getCommentsDAO();

	public void save(Comments ins) throws DBException, ServiceException{
		try {
			 dao.save(ins);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	public int countNoOfComments(int cmtPostId) throws DBException, ServiceException{
		try {
			 return dao.countNoOfComments(cmtPostId);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	public List<Comments> findAllComments(Comments l) throws DBException, ServiceException{
		try {
			 return dao.findAllComments(l);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

}
