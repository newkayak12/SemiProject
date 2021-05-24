package com.cart.model.vo;

public class Cart {
	String productId,categoryId,productOptionSize, productOptionColor, productName;
	int productPrice, productCount;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", categoryId=" + categoryId + ", productOptionSize="
				+ productOptionSize + ", productOptionColor=" + productOptionColor + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productCount=" + productCount + "]";
	}
}
