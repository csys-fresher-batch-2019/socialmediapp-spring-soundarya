package com.soundarya.socialmedia.dao;

import java.util.List;

import com.soundarya.socialmedia.domain.Likes;
import com.soundarya.socialmedia.exception.DBException;

public interface LikesDAO {

	public void save(Likes add) throws DBException;
	
	public int countNoOfLikes(int likePostId) throws DBException;
	
	List<Likes> findAllLikes(Likes l) throws DBException;

}
