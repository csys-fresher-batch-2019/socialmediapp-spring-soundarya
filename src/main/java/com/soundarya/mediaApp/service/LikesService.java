package com.soundarya.mediaApp.service;

import java.util.List;

import com.soundarya.mediaApp.dao.LikesDAO;
import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

public class LikesService {
	LikesDAO dao=DAOFactory.getLikesDAO();
	public void addLikes(Likes add) throws DBException, ServiceException{
		try {
			 dao.addLikes(add);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	public int noOfLikes(int likePostId) throws DBException, ServiceException{
		try {
			 return dao.noOfLikes(likePostId);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<Likes> displayLikes(Likes l) throws DBException, ServiceException{
		try {
			 return dao.displayLikes(l);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	
}
