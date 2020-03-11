package com.soundarya.mediaApp.service;

import java.util.List;

import com.soundarya.mediaApp.dao.PostsDAO;
import com.soundarya.mediaApp.domain.Posts;
import com.soundarya.mediaApp.exception.DBException;
import com.soundarya.mediaApp.exception.ServiceConstant;
import com.soundarya.mediaApp.exception.ServiceException;
import com.soundarya.mediaApp.factory.DAOFactory;

public class PostsService {
	PostsDAO dao=DAOFactory.getPostsDAO();

	public void addPosts(Posts add) throws DBException, ServiceException{
		try {
			dao.addPosts(add);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	int NoOfPosts(String email) throws DBException, ServiceException{
		try {
			return dao.NoOfPosts(email);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void updatePost(Posts up) throws DBException, ServiceException{
		try {
			dao.updatePost(up);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}
	public List<Posts> display() throws DBException, ServiceException{
		try {
			return dao.display();
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Posts> displayFriendsPost(String req) throws DBException, ServiceException{
		try {
			return dao.displayFriendsPost(req);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Posts> displayPublicPost() throws DBException, ServiceException{
		try {
			return dao.displayPublicPost();
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	
	public List<Posts> displayFriendsPost1(String acp) throws DBException, ServiceException{
		try {
			return dao.displayFriendsPost1(acp);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public void deletePost(Posts d) throws DBException, ServiceException{
		try {
			dao.deletePost(d);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}
	}
	
	public List<Posts> MyPosts(String emailId) throws DBException, ServiceException{
		try {
			return dao.MyPosts(emailId);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}


}
