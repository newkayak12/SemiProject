package com.review.model.vo;

public class ReviewComment {

	private String reviewCommentNo;
	private String reviewCommentUserId;
	private String reviewCommentContent;
	private String reviewCommentDate;
	private String reviewNo;
	
	public ReviewComment() {
	
	}

	public ReviewComment(String reviewCommentNo, String reviewCommentUserId, String reviewCommentContent,
			String reviewCommentDate, String reviewNo) {
		this.reviewCommentNo = reviewCommentNo;
		this.reviewCommentUserId = reviewCommentUserId;
		this.reviewCommentContent = reviewCommentContent;
		this.reviewCommentDate = reviewCommentDate;
		this.reviewNo = reviewNo;
	}

	public String getReviewCommentNo() {
		return reviewCommentNo;
	}

	public void setReviewCommentNo(String reviewCommentNo) {
		this.reviewCommentNo = reviewCommentNo;
	}

	public String getReviewCommentUserId() {
		return reviewCommentUserId;
	}

	public void setReviewCommentUserId(String reviewCommentUserId) {
		this.reviewCommentUserId = reviewCommentUserId;
	}

	public String getReviewCommentContent() {
		return reviewCommentContent;
	}

	public void setReviewCommentContent(String reviewCommentContent) {
		this.reviewCommentContent = reviewCommentContent;
	}

	public String getReviewCommentDate() {
		return reviewCommentDate;
	}

	public void setReviewCommentDate(String reviewCommentDate) {
		this.reviewCommentDate = reviewCommentDate;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	@Override
	public String toString() {
		return "ReviewComment [reviewCommentNo=" + reviewCommentNo + ", reviewCommentUserId=" + reviewCommentUserId
				+ ", reviewCommentContent=" + reviewCommentContent + ", reviewCommentDate=" + reviewCommentDate
				+ ", reviewNo=" + reviewNo + "]";
	}
	
	
	
}
