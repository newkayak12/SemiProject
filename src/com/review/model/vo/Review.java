package com.review.model.vo;

import java.util.Date;

public class Review {
	
	// 필드 16개
	private String reviewNo;
	private String userId;
	private String productId;
	private String productOptionSize;
	private String productOptionColor;
	private String reviewTitle;
	private String reviewContents;
	private Date reviewDate;
	private String reviewDelete;
	private String reviewCount;
	private String reviewFile;
	private String reviewLike;
	private String orderNumber;
	private String categoryId;
	private String productName;
	private String productFile;
	
	// 리뷰댓글 테이블이랑도 jojin할거라서 필드 3개 추가요~
	private String commentUserId;
	private String reviewComment;
	private String reviewCommentDate;
	
	// 총 필드 19개 
	
	public Review() {
		
	}


	public Review(String reviewNo, String userId, String productId, String productOptionSize, String productOptionColor,
			String reviewTitle, String reviewContents, Date reviewDate, String reviewDelete, String reviewCount,
			String reviewFile, String reviewLike, String orderNumber, String categoryId, String productName,
			String productFile, String commentUserId, String reviewComment, String reviewCommentDate) {
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.productId = productId;
		this.productOptionSize = productOptionSize;
		this.productOptionColor = productOptionColor;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
		this.reviewDelete = reviewDelete;
		this.reviewCount = reviewCount;
		this.reviewFile = reviewFile;
		this.reviewLike = reviewLike;
		this.orderNumber = orderNumber;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productFile = productFile;
		this.commentUserId = commentUserId;
		this.reviewComment = reviewComment;
		this.reviewCommentDate = reviewCommentDate;
	}


	public String getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductOptionSize() {
		return productOptionSize;
	}


	public void setProductOptionSize(String productOptionSize) {
		this.productOptionSize = productOptionSize;
	}


	public String getProductOptionColor() {
		return productOptionColor;
	}


	public void setProductOptionColor(String productOptionColor) {
		this.productOptionColor = productOptionColor;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getReviewContents() {
		return reviewContents;
	}


	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}


	public String getReviewDelete() {
		return reviewDelete;
	}


	public void setReviewDelete(String reviewDelete) {
		this.reviewDelete = reviewDelete;
	}


	public String getReviewCount() {
		return reviewCount;
	}


	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}


	public String getReviewFile() {
		return reviewFile;
	}


	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}


	public String getReviewLike() {
		return reviewLike;
	}


	public void setReviewLike(String reviewLike) {
		this.reviewLike = reviewLike;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductFile() {
		return productFile;
	}


	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}


	public String getCommentUserId() {
		return commentUserId;
	}


	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}


	public String getReviewComment() {
		return reviewComment;
	}


	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}


	public String getReviewCommentDate() {
		return reviewCommentDate;
	}


	public void setReviewCommentDate(String reviewCommentDate) {
		this.reviewCommentDate = reviewCommentDate;
	}


	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", userId=" + userId + ", productId=" + productId
				+ ", productOptionSize=" + productOptionSize + ", productOptionColor=" + productOptionColor
				+ ", reviewTitle=" + reviewTitle + ", reviewContents=" + reviewContents + ", reviewDate=" + reviewDate
				+ ", reviewDelete=" + reviewDelete + ", reviewCount=" + reviewCount + ", reviewFile=" + reviewFile
				+ ", reviewLike=" + reviewLike + ", orderNumber=" + orderNumber + ", categoryId=" + categoryId
				+ ", productName=" + productName + ", productFile=" + productFile + ", commentUserId=" + commentUserId
				+ ", reviewComment=" + reviewComment + ", reviewCommentDate=" + reviewCommentDate + "]";
	}
	
	
	
}