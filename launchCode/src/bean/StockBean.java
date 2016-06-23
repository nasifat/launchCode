package com.app.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import launchCode.MaterialDAO;
import launchCode.MaterialDAOImpl;
import launchCode.RawMaterial;

@ManagedBean
@SessionScoped
public class StockBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaterialDAO materialDao = new MaterialDAOImpl("com.mysql.jdbc.Driver","jdbc:mysql://localhost/inventory_app"); 
	private String idNumber;
    private String name;
    private String description;
    private String quantity;
    private String totalPrice;
    private String unitPrice;
    private String unit;
    
    
    
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void stockData (ActionEvent e){
		try {
			RawMaterial rawMaterial = new RawMaterial();
			rawMaterial.setMaterialId(Integer.parseInt(idNumber));
			rawMaterial.setName(name);
			rawMaterial.setDescription(description);
			rawMaterial.setUserId("naaz");
			rawMaterial.setQuantity(Integer.parseInt(quantity));
			rawMaterial.setUnitPrice(unitPrice);
			double totPrice = Double.parseDouble(unitPrice)*Double.parseDouble(quantity);
			rawMaterial.setTotalPrice(String.valueOf(totPrice));
			rawMaterial.setUnit(unit);
			try {
				materialDao.upDate(rawMaterial);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
