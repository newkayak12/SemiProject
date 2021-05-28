package com.admin.model.vo.product;

public class ProductAjax {
	private String pId, cId, pName, pPrice, pFile, pFiledetail1, pFiledetail2, pExplain, pDetail, color, size;
	private int stock;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpFile() {
		return pFile;
	}
	public void setpFile(String pFile) {
		this.pFile = pFile;
	}
	public String getpFiledetail1() {
		return pFiledetail1;
	}
	public void setpFiledetail1(String pFiledetail1) {
		this.pFiledetail1 = pFiledetail1;
	}
	public String getpFiledetail2() {
		return pFiledetail2;
	}
	public void setpFiledetail2(String pFiledetail2) {
		this.pFiledetail2 = pFiledetail2;
	}
	public String getpExplain() {
		return pExplain;
	}
	public void setpExplain(String pExplain) {
		this.pExplain = pExplain;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public ProductAjax(String pId, String cId, String pName, String pPrice, String pFile, String pFiledetail1,
			String pFiledetail2, String pExplain, String pDetail, String color, String size, int stock) {
		super();
		this.pId = pId;
		this.cId = cId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pFile = pFile;
		this.pFiledetail1 = pFiledetail1;
		this.pFiledetail2 = pFiledetail2;
		this.pExplain = pExplain;
		this.pDetail = pDetail;
		this.color = color;
		this.size = size;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "ProductAjax [pId=" + pId + ", cId=" + cId + ", pName=" + pName + ", pPrice=" + pPrice + ", pFile="
				+ pFile + ", pFiledetail1=" + pFiledetail1 + ", pFiledetail2=" + pFiledetail2 + ", pExplain=" + pExplain
				+ ", pDetail=" + pDetail + ", color=" + color + ", size=" + size + ", stock=" + stock + "]";
	}
	
	
	public ProductAjax() {
		// TODO Auto-generated constructor stub
	}
	
	
}
