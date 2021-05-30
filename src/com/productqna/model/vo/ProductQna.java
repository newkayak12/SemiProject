package com.productqna.model.vo;

import java.util.Date;

public class ProductQna {
	
	private String qnaProductSeq, qnaUserId, qnaTitle, qnaContent;
	private Date qnaDate;
	private String cId,pId;
	private String qnaCommentSeq, qnaCommentUserId;
	private Date qnaCommentDate;
	private String qnaCommentRef, qnaCommentcontent;
	
	
	public String getQnaCommentcontent() {
		return qnaCommentcontent;
	}


	public void setQnaCommentcontent(String qnaCommentcontent) {
		this.qnaCommentcontent = qnaCommentcontent;
	}


	public ProductQna() {
		// TODO Auto-generated constructor stub
	}


	public String getQnaProductSeq() {
		return qnaProductSeq;
	}


	public void setQnaProductSeq(String qnaProductSeq) {
		this.qnaProductSeq = qnaProductSeq;
	}


	public String getQnaUserId() {
		return qnaUserId;
	}


	public void setQnaUserId(String qnaUserId) {
		this.qnaUserId = qnaUserId;
	}


	public String getQnaTitle() {
		return qnaTitle;
	}


	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}


	public String getQnaContent() {
		return qnaContent;
	}


	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}


	public Date getQnaDate() {
		return qnaDate;
	}


	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
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


	public String getQnaCommentSeq() {
		return qnaCommentSeq;
	}


	public void setQnaCommentSeq(String qnaCommentSeq) {
		this.qnaCommentSeq = qnaCommentSeq;
	}


	public String getQnaCommentUserId() {
		return qnaCommentUserId;
	}


	public void setQnaCommentUserId(String qnaCommentUserId) {
		this.qnaCommentUserId = qnaCommentUserId;
	}


	public Date getQnaCommentDate() {
		return qnaCommentDate;
	}


	public void setQnaCommentDate(Date qnaCommentDate) {
		this.qnaCommentDate = qnaCommentDate;
	}


	public String getQnaCommentRef() {
		return qnaCommentRef;
	}


	public void setQnaCommentRef(String qnaCommentRef) {
		this.qnaCommentRef = qnaCommentRef;
	}


	@Override
	public String toString() {
		return "ProductQna [qnaProductSeq=" + qnaProductSeq + ", qnaUserId=" + qnaUserId + ", qnaTitle=" + qnaTitle
				+ ", qnaContent=" + qnaContent + ", qnaDate=" + qnaDate + ", cId=" + cId + ", pId=" + pId
				+ ", qnaCommentSeq=" + qnaCommentSeq + ", qnaCommentUserId=" + qnaCommentUserId + ", qnaCommentDate="
				+ qnaCommentDate + ", qnaCommentRef=" + qnaCommentRef + "]";
	}
	
	
	
}
