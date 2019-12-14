package com.lab10;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ProductController {
	
	DAO dao;
	ArrayList<Product> products;
	
	public ProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadProducts() {
		System.out.println("In loadproducts()");
		try {
			//calls the dao class method
			products = dao.loadProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteProduct(int p) {
		try {
			dao.deleteProduct(p);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
}
