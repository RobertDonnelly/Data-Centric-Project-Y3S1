package com.lab10;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

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
	
	public void loadStoreProducts(int sp) {
		System.out.println("In loadStoreProducts()");
		try {
			storeProducts = dao.loadStoreProducts(sp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<StoreProduct> getStoreProducts() {
		return storeProducts;
	}
}




	