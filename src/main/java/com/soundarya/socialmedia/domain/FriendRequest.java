package com.soundarya.socialmedia.domain;

public class FriendRequest {
	private String requestor;
	private String acceptor;
	private String currentStatus;

	@Override
	public String toString() {
		return "FriendRequest [requestor=" + requestor + ", acceptor=" + acceptor + ", currentStatus=" + currentStatus
				+ "]";
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

}
