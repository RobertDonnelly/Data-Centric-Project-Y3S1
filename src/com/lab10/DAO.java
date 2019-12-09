package com.lab10;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	DataSource mysqlDS;
	
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	public ArrayList<Product> loadProducts() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from product";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Product> products = new ArrayList<Product>();

		// process result set
		while (myRs.next()) {
			Product p = new Product();
			p.setProdID(myRs.getInt("pid"));
			p.setShopID(myRs.getInt("sid"));
			p.setDesc(myRs.getString("prodName"));
			p.setPrice(myRs.getDouble("price"));
			products.add(p);
		}
		return products;
	}
	
	
public ArrayList<Store> loadStores() throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from store";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);
		
		ArrayList<Store> stores = new ArrayList<Store>();

		// process result set
		while (myRs.next()) {
			Store s = new Store();
			s.setStoreID(myRs.getInt("id"));
			s.setShopName(myRs.getString("name"));
			s.setFounded(myRs.getString("founded"));
			stores.add(s);
		}
		return stores;
	}
	
	public void addStore(Store store) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store values (?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, store.getShopName());
		myStmt.setString(2, store.getFounded());

		myStmt.execute();			
	}
	
	public void deleteProduct(int pid) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from product where prodid = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, pid);
		myStmt.execute();			
	}
}
