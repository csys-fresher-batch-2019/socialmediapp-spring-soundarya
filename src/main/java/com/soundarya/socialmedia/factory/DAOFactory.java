package com.soundarya.socialmedia.factory;

import com.soundarya.socialmedia.dao.CommentsDAO;
import com.soundarya.socialmedia.dao.FriendRequestDAO;
import com.soundarya.socialmedia.dao.LikesDAO;
import com.soundarya.socialmedia.dao.LoginDAO;
import com.soundarya.socialmedia.dao.PostsDAO;
import com.soundarya.socialmedia.dao.UserListDAO;
import com.soundarya.socialmedia.dao.impl.CommentsImpl;
import com.soundarya.socialmedia.dao.impl.FriendRequestImpl;
import com.soundarya.socialmedia.dao.impl.LikesImpl;
import com.soundarya.socialmedia.dao.impl.LoginImpl;
import com.soundarya.socialmedia.dao.impl.PostsImpl;
import com.soundarya.socialmedia.dao.impl.UserListImpl;

public class DAOFactory {
	public static UserListDAO getUserListDAO() {
		return new UserListImpl();
	}
	public static FriendRequestDAO getFriendRequestDAO() {
		return new FriendRequestImpl();
	}
	public static PostsDAO getPostsDAO() {
		return new PostsImpl();
	}
	public static LikesDAO getLikesDAO() {
		return new LikesImpl();
	}
	public static CommentsDAO getCommentsDAO() {
		return new CommentsImpl();
	}
	public static LoginDAO getLoginDAO() {
		return new LoginImpl();
	}
}
