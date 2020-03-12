package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;

public interface LikesDAO {

	public void save(Likes add) throws DBException;
	
	public int countNoOfLikes(int likePostId) throws DBException;
	
	List<Likes> findAllLikes(Likes l) throws DBException;

}
