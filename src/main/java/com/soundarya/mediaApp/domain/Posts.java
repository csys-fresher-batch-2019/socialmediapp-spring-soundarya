package com.soundarya.mediaApp.domain;

public class Posts {

	private String userName;
	 private int postId;
	 private String email;
	 private String postType;
	 private String caption;
	 private String viewability;
	 private String datePosted;
	 
	 public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

	public int getPostId() {
		return postId;
	}



	public void setPostId(int postId) {
		this.postId = postId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPostType() {
		return postType;
	}



	public void setPostType(String postType) {
		this.postType = postType;
	}



	public String getCaption() {
		return caption;
	}



	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getViewability() {
		return viewability;
	}



	public void setViewability(String viewability) {
		this.viewability = viewability;
	}



	public String getDatePosted() {
		return datePosted;
	}



	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}



	


	
	
	@Override
	public String toString() {
		return "PostsClass [userName=" + userName + ", postId=" + postId + ", email=" + email + ", postType=" + postType
				+ ", caption=" + caption + ", viewability=" + viewability + ", datePosted=" + datePosted + "]";
	}
	
	public String toString1() {
		return "PostsClass [userName=" + userName + ",email=" + email + ",  postType=" + postType
				+ ", caption=" + caption + ",  datePosted=" + datePosted + "]";
	}

	public String toString2() {
		return "PostsClass [ postId=" + postId + ", email=" + email + ", postType=" + postType
				+ ", caption=" + caption + ",  datePosted=" + datePosted + "]";
	}

}
