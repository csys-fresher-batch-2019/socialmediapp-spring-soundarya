package com.soundarya.mediaApp.domain;

public class Likes {
	private int likePostId;
	 private String likeEmail;
	 private String likeDate;
	
	
	

	@Override
	public String toString() {
		return "LikesClass [likeEmail=" + likeEmail + ", likeDate=" + likeDate + "]";
	}


	public int getLikePostId() {
		return likePostId;
	}


	public void setLikePostId(int likePostId) {
		this.likePostId = likePostId;
	}


	public String getLikeEmail() {
		return likeEmail;
	}


	public void setLikeEmail(String likeEmail) {
		this.likeEmail = likeEmail;
	}

	public String getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}

	
}
