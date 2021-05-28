package com.users.model.vo;

public class Users {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAdmin;
	private String userAddr;
	private String userZip;
	private int userStatus;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Users(String userId, String userPwd, String userName, String userEmail, String userPhone, String userAdmin,
			String userAddr, String userZip, int userStatus) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAdmin = userAdmin;
		this.userAddr = userAddr;
		this.userZip = userZip;
		this.userStatus = userStatus;
	}

	
	public int getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserZip() {
		return userZip;
	}

	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", userAdmin=" + userAdmin + ", userAddr=" + userAddr
				+ ", userZip=" + userZip + ", userStatus=" + userStatus + "]";
	}

	

	
	
	
}