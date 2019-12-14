package com.lab10;


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class StoreProductController {
	
	DAO dao;
	ArrayList<StoreProduct> storeProducts;
	
	public StoreProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String loadStoreProducts(int sp) {
		System.out.println("In loadStoreProducts()");
		try {
			storeProducts = dao.loadStoreProducts(sp);
			return "storeProduct";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<StoreProduct> getStoreProducts() {
		return storeProducts;
	}
}




	