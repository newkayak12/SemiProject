package com.cart.model.vo;

public class Cart {
	private String productId;
	private String categoryId;
	private String cartOptionSize;
	private String cartOptionColor;
	private String cartName;
	private String cartPrice;
	private int cartStock;
	private String productFile, productExplain;
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
	public String getCartOptionSize() {
		return cartOptionSize;
	}
	public void setCartOptionSize(String cartOptionSize) {
		this.cartOptionSize = cartOptionSize;
	}
	public String getCartOptionColor() {
		return cartOptionColor;
	}
	public void setCartOptionColor(String cartOptionColor) {
		this.cartOptionColor = cartOptionColor;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public String getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(String cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getProductFile() {
		return productFile;
	}
	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}
	public String getProductExplain() {
		return productExplain;
	}
	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", categoryId=" + categoryId + ", cartOptionSize=" + cartOptionSize
				+ ", cartOptionColor=" + cartOptionColor + ", cartName=" + cartName + ", cartPrice=" + cartPrice
				+ ", cartStock=" + cartStock + ", productFile=" + productFile + ", productExplain=" + productExplain
				+ "]";
	}

	
	
}