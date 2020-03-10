package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.dao.impl.CommentsImpl;
import com.soundarya.mediaApp.dao.impl.LikesImpl;
import com.soundarya.mediaApp.domain.Comments;
import com.soundarya.mediaApp.domain.Likes;
import com.soundarya.mediaApp.exception.DBException;

public interface CommentsDAO {
	
		public void insertComments(Comments ins) throws DBException;
		
		
		public List<Comments> displayPostsWithComments() throws DBException;
		
		public int noOfComments(int cmtPostId) throws DBException;
		
		public List<Comments> displayComments(Comments l) throws DBException;

}
