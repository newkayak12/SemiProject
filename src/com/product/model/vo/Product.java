package com.product.model.vo;

public class Product {
	private int productId;
	private String categoryId;
	private String productOptionSize;
	private String productOptionColor;
	private String productName;
	private String productPrice;
	private int productStock;
	private String productFile;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String categoryId, String productOptionSize, String productOptionColor,
			String productName, String productPrice, int productStock, String productFile) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productOptionSize = productOptionSize;
		this.productOptionColor = productOptionColor;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productFile = productFile;
	}

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

	@Override
	public String toString() {
		return "Item [productId=" + productId + ", categoryId=" + categoryId + ", productOptionSize="
				+ productOptionSize + ", productOptionColor=" + productOptionColor + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productStock=" + productStock + ", productFile=" + productFile
				+ "]";
	}
	
	
}

