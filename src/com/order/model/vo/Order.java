package com.order.model.vo;

import java.util.Date;

public class Order {
	String OrderNumber;
	String productId, categoryId, productSize, productColor;
	int orderdetailcount;
	Date orderDate;
	String productprice;
	int orderStatus, orderCompleted;
	String productName;
	String productFile;
	String address,zipcode,phone;
	int totalPrice;
	
	String orderusername, receivername;
	
	int howmany;
	
	String orderstat;
	
	
	
	
	public String getOrderstat() {
		return orderstat;
	}
	public void setOrderstat(String orderstat) {
		this.orderstat = orderstat;
	}
	public int getHowmany() {
		return howmany;
	}
	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}
	public String getOrderusername() {
		return orderusername;
	}
	public void setOrderusername(String orderusername) {
		this.orderusername = orderusername;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
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
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public int getOrderdetailcount() {
		return orderdetailcount;
	}
	public void setOrderdetailcount(int orderdetailcount) {
		this.orderdetailcount = orderdetailcount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderCompleted() {
		return orderCompleted;
	}
	public void setOrderCompleted(int orderCompleted) {
		this.orderCompleted = orderCompleted;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [OrderNumber=" + OrderNumber + ", productId=" + productId + ", categoryId=" + categoryId
				+ ", productSize=" + productSize + ", productColor=" + productColor + ", orderdetailcount="
				+ orderdetailcount + ", orderDate=" + orderDate + ", productprice=" + productprice + ", orderStatus="
				+ orderStatus + ", orderCompleted=" + orderCompleted + ", productName=" + productName + ", productFile="
				+ productFile + ", address=" + address + ", zipcode=" + zipcode + ", phone=" + phone + ", totalPrice="
				+ totalPrice + "]";
	} 
	
	
	
}