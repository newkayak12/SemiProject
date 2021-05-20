package com.users.model.vo;

public class Users {
	String userId,userPwd,userName,userEmail,userPhone,userAdmin,userAddr,userZip;

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
		return "Users [userId=" + userId + ", userPwd=" + userPwd +  ", userName="
				+ userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userAdmin=" + userAdmin
				+ ", userAddr=" + userAddr + ", userZip=" + userZip + "]";
	}
	
	
}