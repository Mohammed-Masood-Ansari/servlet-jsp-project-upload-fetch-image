package com.servlet_simple_project.dto;

import java.io.InputStream;

public class User {

	private int userId;
	private String userName;
	private InputStream userImage;

	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userImage
	 */
	public InputStream getUserImage() {
		return userImage;
	}
	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(InputStream userImage) {
		this.userImage = userImage;
	}
	
	
}
