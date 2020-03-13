package com.soundarya.socialmedia.domain;

import java.time.LocalDateTime;

public class Comments {
	private String userName;
	private String caption;
	private int cmtPostId;
	private String cmtEmail;
	private String cmts;
	private LocalDateTime cmtDate=LocalDateTime.now();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getCmtPostId() {
		return cmtPostId;
	}
	public void setCmtPostId(int cmtPostId) {
		this.cmtPostId = cmtPostId;
	}
	public String getCmtEmail() {
		return cmtEmail;
	}
	public void setCmtEmail(String cmtEmail) {
		this.cmtEmail = cmtEmail;
	}
	public String getCmts() {
		return cmts;
	}
	public void setCmts(String cmts) {
		this.cmts = cmts;
	}
	public LocalDateTime getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(LocalDateTime cmtDate) {
		this.cmtDate = cmtDate;
	}
	@Override
	public String toString() {
		return "Comments [userName=" + userName + ", caption=" + caption + ", cmtPostId=" + cmtPostId + ", cmtEmail="
				+ cmtEmail + ", cmts=" + cmts + ", cmtDate=" + cmtDate + "]";
	}

	}