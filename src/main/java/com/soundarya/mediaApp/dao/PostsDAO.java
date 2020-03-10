package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.domain.Posts;
import com.soundarya.mediaApp.exception.DBException;

public interface PostsDAO {

	
	public void addPosts(Posts add) throws DBException;
	
	
	int NoOfPosts(String email) throws DBException;
	
	
	public void updatePost(Posts up) throws DBException;
    
    
	public List<Posts> display() throws DBException;
	
	public List<Posts> displayFriendsPost(String req) throws DBException;
	
	public List<Posts> displayPublicPost() throws DBException;
	public List<Posts> displayFriendsPost1(String acp) throws DBException;
	
	public void deletePost(Posts d) throws DBException;
	
	public 	List<Posts> MyPosts(String emailId) throws DBException;
}
