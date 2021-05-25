package com.qna.model.vo;

import java.util.Date;

public class Qna {
	
	private String qSeq; // qna 시퀀스
	private String userId; // userId
	private String qTitle; // qna 제목
	private String qContents; // qna 내용
	private String qFile; // qna 파일
	private Date qDate; // qna 작성날짜
	private String cId; // 상품 카테고리 아이디
	private String pId; // 상품 아이디
	
	// ---- PRODUCT FK ------
	 private String pName; // 상품 이름
	 
	 // ---- QNA_COMMENT FK ----
	 private String qComment;
	 private String qCommentId;
	 private Date qCommentDate;
	 
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}


	public Qna(String qSeq, String userId, String qTitle, String qContents, String qFile, Date qDate, String cId,
			String pId, String pName, String qComment, String qCommentId, Date qCommentDate) {
		super();
		this.qSeq = qSeq;
		this.userId = userId;
		this.qTitle = qTitle;
		this.qContents = qContents;
		this.qFile = qFile;
		this.qDate = qDate;
		this.cId = cId;
		this.pId = pId;
		this.pName = pName;
		this.qComment = qComment;
		this.qCommentId = qCommentId;
		this.qCommentDate = qCommentDate;
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


	public String getqContents() {
		return qContents;
	}


	public void setqContents(String qContents) {
		this.qContents = qContents;
	}


	public String getqFile() {
		return qFile;
	}


	public void setqFile(String qFile) {
		this.qFile = qFile;
	}


	public Date getqDate() {
		return qDate;
	}


	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}


	public String getcId() {
		return cId;
	}


	public void setcId(String cId) {
		this.cId = cId;
	}


	public String getpId() {
		return pId;
	}


	public void setpId(String pId) {
		this.pId = pId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getqComment() {
		return qComment;
	}


	public void setqComment(String qComment) {
		this.qComment = qComment;
	}


	public String getqCommentId() {
		return qCommentId;
	}


	public void setqCommentId(String qCommentId) {
		this.qCommentId = qCommentId;
	}


	public Date getqCommentDate() {
		return qCommentDate;
	}


	public void setqCommentDate(Date qCommentDate) {
		this.qCommentDate = qCommentDate;
	}


	@Override
	public String toString() {
		return "Qna [qSeq=" + qSeq + ", userId=" + userId + ", qTitle=" + qTitle + ", qContents=" + qContents
				+ ", qFile=" + qFile + ", qDate=" + qDate + ", cId=" + cId + ", pId=" + pId + ", pName=" + pName
				+ ", qComment=" + qComment + ", qCommentId=" + qCommentId + ", qCommentDate=" + qCommentDate + "]";
	}
}

	