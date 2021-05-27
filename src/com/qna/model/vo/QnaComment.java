package com.qna.model.vo;

import java.sql.Date;

public class QnaComment {
	private String qSeq;
	private String userId;
	private String qComment;
	private Date qDate;
	private String qRef;
	
	public QnaComment() {
		// TODO Auto-generated constructor stub
	}

	public QnaComment(String qSeq, String userId, String qComment, Date qDate, String qRef) {
		super();
		this.qSeq = qSeq;
		this.userId = userId;
		this.qComment = qComment;
		this.qDate = qDate;
		this.qRef = qRef;
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

	public String getqComment() {
		return qComment;
	}

	public void setqComment(String qComment) {
		this.qComment = qComment;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	public String getqRef() {
		return qRef;
	}

	public void setqRef(String qRef) {
		this.qRef = qRef;
	}

	@Override
	public String toString() {
		return "QnaComment [qSeq=" + qSeq + ", userId=" + userId + ", qComment=" + qComment + ", qDate=" + qDate
				+ ", qRef=" + qRef + "]";
	}
	
	
}
