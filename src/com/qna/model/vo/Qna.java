package com.qna.model.vo;

import java.sql.Date;

public class Qna {
	
	private String qSeq;
	private String userId;
	private String qTitle;
	private String qFile;
	private String qContents;
	private Date qDate;

	public Qna() {
		// TODO Auto-generated constructor stub
	}

	public Qna(String qSeq, String userId, String qTitle, String qFile, String qContents, Date qDate) {
		super();
		this.qSeq = qSeq;
		this.userId = userId;
		this.qTitle = qTitle;
		this.qFile = qFile;
		this.qContents = qContents;
		this.qDate = qDate;
	}

	public String getqSeq() {
		return qSeq;
	}

	public void setqSeq(String qSeq) {
		this.qSeq = qSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqFile() {
		return qFile;
	}

	public void setqFile(String qFile) {
		this.qFile = qFile;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	@Override
	public String toString() {
		return "Qna [qSeq=" + qSeq + ", userId=" + userId + ", qTitle=" + qTitle + ", qFile=" + qFile + ", qContents="
				+ qContents + ", qDate=" + qDate + "]";
	}

	
	
	
}

	