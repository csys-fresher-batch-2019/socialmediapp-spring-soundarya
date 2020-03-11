package com.soundarya.mediaApp.dao;

import java.util.List;

import com.soundarya.mediaApp.domain.FriendRequest;
import com.soundarya.mediaApp.exception.DBException;

public interface FriendRequestDAO {

	void insertRequest(FriendRequest ins) throws DBException;

	List<FriendRequest> getFriendrequest(String requestor, String s) throws DBException;

	List<FriendRequest> getRequestorList(String requestor) throws DBException;

	List<FriendRequest> getAcceptorList(String requestor) throws DBException;

	void updateStatus(String currentStatus, String requestor, String acceptor) throws DBException;

}
