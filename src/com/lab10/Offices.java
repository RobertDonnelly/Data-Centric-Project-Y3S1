package com.lab10;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Offices {
	int storeID;
	String hq;
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getHq() {
		return hq;
	}
	public void setHq(String hq) {
		this.hq = hq;
	}
}
