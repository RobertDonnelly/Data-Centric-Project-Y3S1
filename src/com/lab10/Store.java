package com.lab10;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Store {
	//declare variables
	int storeID;
	String shopName;
	String founded;
	
	//getters & setters
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}
}
