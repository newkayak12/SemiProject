package com.product.model.vo;

public class Product {
	private int productId;
	private String categoryId;
	private String productOptionSize;
	private String productOptionColor;
	private String productName;
	private String productPrice;
	private int productStock;
	private String productFile, productFileDetail1 ,productFileDetail2, productExplain;
	private int productViewCount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
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
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductFile() {
		return productFile;
	}
	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}
	public String getProductFileDetail1() {
		return productFileDetail1;
	}
	public void setProductFileDetail1(String productFileDetail1) {
		this.productFileDetail1 = productFileDetail1;
	}
	public String getProductFileDetail2() {
		return productFileDetail2;
	}
	public void setProductFileDetail2(String productFileDetail2) {
		this.productFileDetail2 = productFileDetail2;
	}
	public String getProductExplain() {
		return productExplain;
	}
	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}
	public int getProductViewCount() {
		return productViewCount;
	}
	public void setProductViewCount(int productViewCount) {
		this.productViewCount = productViewCount;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productOptionSize="
				+ productOptionSize + ", productOptionColor=" + productOptionColor + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productStock=" + productStock + ", productFile=" + productFile
				+ ", productFileDetail1=" + productFileDetail1 + ", productFileDetail2=" + productFileDetail2
				+ ", productExplain=" + productExplain + ", productViewCount=" + productViewCount + "]";
	}
	
}