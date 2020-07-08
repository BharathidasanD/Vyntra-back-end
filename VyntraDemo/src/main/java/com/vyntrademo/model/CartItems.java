package com.vyntrademo.model;

import java.util.List;
public class CartItems {
	
	private Double  totalPrice;
	

	private byte[] picByte;
	
	
	private List<ShoppingCart> listCart;


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


	public List<ShoppingCart> getListCart() {
		return listCart;
	}


	public void setListCart(List<ShoppingCart> listCart) {
		this.listCart = listCart;
	}


	
	
	

}
