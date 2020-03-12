package com.soundarya.mediaApp.domain;

import java.time.LocalDateTime;

public class Likes {
	private int likePostId;
	private String likeEmail;
	private LocalDateTime likeDate=LocalDateTime.now();
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
	public LocalDateTime getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(LocalDateTime likeDate) {
		this.likeDate = likeDate;
	}
	@Override
	public String toString() {
		return "Likes [likePostId=" + likePostId + ", likeEmail=" + likeEmail + ", likeDate=" + likeDate + "]";
	}

	}
