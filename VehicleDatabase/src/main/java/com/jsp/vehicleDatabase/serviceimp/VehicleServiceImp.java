
package com.jsp.vehicleDatabase.serviceimp;


import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.vehicleDatabase.exception.ResourceNotFoundException;
import com.jsp.vehicleDatabase.model.Vehicle;
import com.jsp.vehicleDatabase.repo.VehicleRepo;
import com.jsp.vehicleDatabase.service.VehicleService;
@Service
public class VehicleServiceImp implements VehicleService {

	@Autowired
	VehicleRepo repo;

	//to save vehicle
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		repo.save(vehicle);
		return vehicle;
	}


	// to get all details
	@Override
	public List<Vehicle> getVehicle() {
		List<Vehicle>list=repo.findAll();
		return list;
	}

	//to get based on id
	@Override
	public Vehicle getById(int id) {
		Optional<Vehicle>vehicle=repo.findById(id);
		if(vehicle.isPresent()) {
			return vehicle.get();
		}
		else {
			throw new ResourceNotFoundException("vehicle","ID",id);

		}
	}

	//to get based on color
	@Override
	public List<Vehicle> getByColor() {

		return repo.getbyColor();
	}

	//sorted by price
	@Override
	public List<Vehicle> getByPriceSorted(int pageNo, int noOfRecords) {
		Pageable pageable=PageRequest.of(pageNo, noOfRecords, Sort.by("vcolor"));
		return repo.getByPriceSorted(pageable);

	}

	//Price more than 1000000
	@Override
	public List<Vehicle> morethan10lakh() {

		return repo.morethan10lakh();
	}

	//to update based on id
	@Override
	public Vehicle updatevehicle(Vehicle vehicle, int id) {
		Vehicle vehicle2=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
		vehicle2.setvName(vehicle.getvName());
		vehicle2.setvPrice(vehicle.getvPrice());
		vehicle2.setvModel(vehicle.getvModel());
		vehicle2.setvColor(vehicle.getvColor());
		repo.save(vehicle2);
		return vehicle2;
	}

	//to delete based on id
	@Override
	public String DeleteVehicle(int id) {
		Vehicle vehicle=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
		repo.delete(vehicle);
		return "Vehicle Deleted";
	}


}
