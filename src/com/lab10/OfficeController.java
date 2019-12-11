package com.lab10;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OfficeController {
	MongoDAO mongo;
	ArrayList<Offices> offices;
	
	//default constructor
	public OfficeController(){
		super();
		try {
			mongo = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadOffices() {
		System.out.println("in loadOffices");
		try {
			offices = mongo.loadOffices();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
