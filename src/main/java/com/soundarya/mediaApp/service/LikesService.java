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
	public void save(Likes add) throws DBException, ServiceException{
		try {
			 dao.save(add);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}
	public int countNoOfLikes(int likePostId) throws DBException, ServiceException{
		try {
			 return dao.countNoOfLikes(likePostId);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	List<Likes> findAllLikes(Likes l) throws DBException, ServiceException{
		try {
			 return dao.findAllLikes(l);
		} catch (DBException e) {	
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	
}
