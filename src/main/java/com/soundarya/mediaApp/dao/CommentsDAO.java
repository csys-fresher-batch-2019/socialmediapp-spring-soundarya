package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.domain.Comments;
import com.soundarya.mediaApp.exception.DBException;

public interface CommentsDAO {
	
		public void save(Comments ins) throws DBException;
			
		public int countNoOfComments(int cmtPostId) throws DBException;
		
		public List<Comments> findAllComments(Comments l) throws DBException;

}
