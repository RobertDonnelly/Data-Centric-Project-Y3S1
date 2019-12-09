package com.lab10;
import java.sql.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Store {
	
	int storeID;
	String shopName;
	Date founded;
	
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
	public Date getFounded() {
		return founded;
	}
	public void setFounded(Date founded) {
		this.founded = founded;
	}
}
