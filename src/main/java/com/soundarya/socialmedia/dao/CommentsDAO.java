package com.soundarya.socialmedia.dao;

import java.util.List;

import com.soundarya.socialmedia.domain.Comments;
import com.soundarya.socialmedia.exception.DBException;

public interface CommentsDAO {
	
		public void save(Comments ins) throws DBException;
			
		public int countNoOfComments(int cmtPostId) throws DBException;
		
		public List<Comments> findAllComments(Comments l) throws DBException;

}
