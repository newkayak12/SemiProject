package com.notice.model.vo;

import java.util.Date;

public class Notice {
	private String nSeq; // 공지번호 -> 시퀀스 
	private String userId;
	private String userAddr;
	private String userZip; 
	private String nTitle; // 공지제목
	private String nContent; // 공지내용
	private Date nDate; // 공지등록 날짜
	private int nDelete; // 0일때, 유지되는 거
	private int nCount; // 공지사항 조회수
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(String nSeq, String userId, String userAddr, String userZip, String nTitle, String nContent,
			Date nDate, int nDelete, int nCount) {
		super();
		this.nSeq = nSeq;
		this.userId = userId;
		this.userAddr = userAddr;
		this.userZip = userZip;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nDelete = nDelete;
		this.nCount = nCount;
	}

	public String getnSeq() {
		return nSeq;
	}

	public void setnSeq(String nSeq) {
		this.nSeq = nSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public int getnDelete() {
		return nDelete;
	}

	public void setnDelete(int nDelete) {
		this.nDelete = nDelete;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	@Override
	public String toString() {
		return "Notice [nSeq=" + nSeq + ", userId=" + userId + ", userAddr=" + userAddr + ", userZip=" + userZip
				+ ", nTitle=" + nTitle + ", nContent=" + nContent + ", nDate=" + nDate + ", nDelete=" + nDelete
				+ ", nCount=" + nCount + "]";
	}
	
	
}
