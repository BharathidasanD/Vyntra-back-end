package com.vyntrademo.model;

import java.util.List;
//not a entity just a model for view
public class CartItems {
	
   private Double  totalPrice;
   private byte[] picByte;
   private String productName;
   private String productDetail;
   private Integer noOfProduct;


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDetail() {
		return productDetail;
	}


	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}


	public Integer getNoOfProduct() {
		return noOfProduct;
	}


	public void setNoOfProduct(Integer noOfProduct) {
		this.noOfProduct = noOfProduct;
	}


	


	
	
	

}
