package com.jsp.vehicleDatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int vid;
	private String vName;
	private long vPrice;
	private int vModel;
	private String vColor;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public long getvPrice() {
		return vPrice;
	}
	public void setvPrice(long vPrice) {
		this.vPrice = vPrice;
	}
	public int getvModel() {
		return vModel;
	}
	public void setvModel(int vModel) {
		this.vModel = vModel;
	}
	public String getvColor() {
		return vColor;
	}
	public void setvColor(String vColor) {
		this.vColor = vColor;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", vName=" + vName + ", vPrice=" + vPrice + ", vModel=" + vModel + ", vColor="
				+ vColor + "]";
	}
	
	
	
	

}
