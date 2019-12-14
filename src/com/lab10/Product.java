package com.lab10;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Product {
	
	//declare variables
	int shopID;
	int prodID;
	String desc;
	double price;
	
	//getters & setters
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	

}
