package com.lab10;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

@ManagedBean
@SessionScoped
public class OfficesController {
	MongoDAO mdao;
	ArrayList<Offices> offices;
	
	//default constructor
	public OfficesController(){
		super();
		try {
			mdao = new MongoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadOffices() {
		System.out.println("in loadOffices");
		try {
			offices = mdao.loadOffices();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String addOffice(Offices o) {
		System.out.println(o.getStoreID() + " " + o.getHq());
		try {
			mdao.addOffice(o);
			return "index";
		} catch (SQLIntegrityConstraintViolationException e) {
			FacesMessage message = 
					new FacesMessage("Error: "+o.getStoreID() +" already exists");
					FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = 
					new FacesMessage("Error: " + e.getMessage());
					FacesContext.getCurrentInstance().addMessage(null, message);

			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Offices> getOffices() {
		return offices;
	}
	
}
