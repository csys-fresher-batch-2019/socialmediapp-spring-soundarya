package com.soundarya.socialmedia.dao;

import java.util.List;

import com.soundarya.socialmedia.domain.Posts;
import com.soundarya.socialmedia.exception.DBException;

public interface PostsDAO {

	public void save(Posts add) throws DBException;

	int countNoOfPosts(String email) throws DBException;

	public void updatePost(Posts up) throws DBException;

	public List<Posts> findAllPosts() throws DBException;

	public List<Posts> findAllFriendsPosts(String req) throws DBException;

	public List<Posts> findAllPublicPosts() throws DBException;

	public List<Posts> findAllFriendsPosts1(String acp) throws DBException;

	public void deletePost(Posts d) throws DBException;

	public List<Posts> findMyPosts(String emailId) throws DBException;
}
