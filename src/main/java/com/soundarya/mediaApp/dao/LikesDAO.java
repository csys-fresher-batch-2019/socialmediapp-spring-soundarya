package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.dao.impl.LikesImpl;
import com.soundarya.mediaApp.dao.impl.UserListImpl;
import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;

public interface LikesDAO {

	public void addLikes(Likes add) throws DBException;
	
	public int noOfLikes(int likePostId) throws DBException;
	
	List<Likes> displayLikes(Likes l) throws DBException;

}
