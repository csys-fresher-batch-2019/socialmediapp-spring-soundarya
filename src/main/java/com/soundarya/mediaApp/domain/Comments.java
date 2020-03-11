package com.soundarya.mediaApp.domain;

public class Comments {
	private String userName;
	private String caption;
	private int cmtPostId;
	private String cmtEmail;
	private String cmts;
	private String cmtDate1;

	@Override
	public String toString() {
		return "Comments [userName=" + userName + ", caption=" + caption + ", cmtPostId=" + cmtPostId + ", cmtEmail="
				+ cmtEmail + ", cmts=" + cmts + ", cmtDate1=" + cmtDate1 + "]";
	}

	public String getCmtDate1() {
		return cmtDate1;
	}

	public void setCmtDate1(String cmtDate1) {
		this.cmtDate1 = cmtDate1;
	}

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

	public String getCmtDate() {
		return cmtDate1;
	}

	public void setCmtDate(String cmtDate1) {
		this.cmtDate1 = cmtDate1;
	}
}