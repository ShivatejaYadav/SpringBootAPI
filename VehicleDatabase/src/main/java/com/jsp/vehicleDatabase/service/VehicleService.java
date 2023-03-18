package com.jsp.vehicleDatabase.service;

import java.util.List;

import com.jsp.vehicleDatabase.model.Vehicle;

public interface VehicleService {
	// to save vehicle
	Vehicle saveVehicle(Vehicle vehicle);

	//to get based on details
	List<Vehicle> getVehicle();

	//to get based on id
	Vehicle getById(int id);

	//to get based on color
	List<Vehicle> getByColor();

	//sorted by price
	List<Vehicle> getByPriceSorted(int pageNo,int noOfRecords);

	//Price more than 1000000
	List<Vehicle> morethan10lakh();

	//to update based on id
	Vehicle updatevehicle(Vehicle vehicle,int id);

	//to delete based on Id
	String DeleteVehicle(int id);


}
