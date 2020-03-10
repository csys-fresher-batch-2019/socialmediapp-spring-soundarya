package com.soundarya.mediaApp.factory;

import com.soundarya.mediaApp.dao.CommentsDAO;
import com.soundarya.mediaApp.dao.FriendRequestDAO;
import com.soundarya.mediaApp.dao.LikesDAO;
import com.soundarya.mediaApp.dao.LoginDAO;
import com.soundarya.mediaApp.dao.PostsDAO;
import com.soundarya.mediaApp.dao.UserListDAO;
import com.soundarya.mediaApp.dao.impl.CommentsImpl;
import com.soundarya.mediaApp.dao.impl.FriendRequestImpl;
import com.soundarya.mediaApp.dao.impl.LikesImpl;
import com.soundarya.mediaApp.dao.impl.LoginImpl;
import com.soundarya.mediaApp.dao.impl.PostsImpl;
import com.soundarya.mediaApp.dao.impl.UserListImpl;

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
