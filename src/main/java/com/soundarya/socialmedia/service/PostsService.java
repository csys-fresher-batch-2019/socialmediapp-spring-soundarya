package com.soundarya.socialmedia.service;

import java.util.List;

import com.soundarya.socialmedia.dao.PostsDAO;
import com.soundarya.socialmedia.domain.Posts;
import com.soundarya.socialmedia.exception.DBException;
import com.soundarya.socialmedia.exception.ServiceConstant;
import com.soundarya.socialmedia.exception.ServiceException;
import com.soundarya.socialmedia.factory.DAOFactory;

public class PostsService {
	PostsDAO dao=DAOFactory.getPostsDAO();

	public void save(Posts add) throws DBException, ServiceException{
		try {
			dao.save(add);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	int countNoOfPosts(String email) throws DBException, ServiceException{
		try {
			return dao.countNoOfPosts(email);
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
	public List<Posts> findAllPosts() throws DBException, ServiceException{
		try {
			return dao.findAllPosts();
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Posts> findAllFriendsPosts(String req) throws DBException, ServiceException{
		try {
			return dao.findAllFriendsPosts(req);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public List<Posts> findAllPublicPosts() throws DBException, ServiceException{
		try {
			return dao.findAllPublicPosts();
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	
	public List<Posts> findAllFriendsPosts1(String acp) throws DBException, ServiceException{
		try {
			return dao.findAllFriendsPosts1(acp);
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
	
	public List<Posts> findMyPosts(String emailId) throws DBException, ServiceException{
		try {
			return dao.findMyPosts(emailId);
		} catch (DBException e) {
			
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}


}
