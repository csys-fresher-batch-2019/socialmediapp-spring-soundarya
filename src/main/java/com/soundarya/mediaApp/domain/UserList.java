package com.soundarya.mediaApp.domain;

import java.sql.Date;

public class UserList {

	private int  userId;
	private String userName;
	private String email;
	private int age;
	private String gender;
	private Date dob;
	private String city;
	private String country;
	Date createdDate;
	private String status;
	private String activestatus;
	private String userPassword;
	private String profilePic;

	
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date Date) {
		this.dob = Date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	
	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}
	@Override
	public String toString() {
		return "UserList [userId=" + userId + ", userName=" + userName + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", city=" + city + ", country=" + country + ", createdDate="
				+ createdDate + ", status=" + status + ", activestatus=" + activestatus + ", userPassword="
				+ userPassword + ", profilePic=" + profilePic + "]";
	}
	
	
}
