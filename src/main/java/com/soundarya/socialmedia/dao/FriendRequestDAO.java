package com.soundarya.socialmedia.dao;

import java.util.List;

import com.soundarya.socialmedia.domain.FriendRequest;
import com.soundarya.socialmedia.exception.DBException;

public interface FriendRequestDAO {

	void save(FriendRequest ins) throws DBException;

	List<FriendRequest> findFriendrequest(String requestor, String s) throws DBException;

	List<FriendRequest> findRequestorList(String requestor) throws DBException;

	List<FriendRequest> findAcceptorList(String requestor) throws DBException;

	void updateStatus(String currentStatus, String requestor, String acceptor) throws DBException;

}
