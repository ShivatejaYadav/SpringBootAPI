package com.jsp.vehicleDatabase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.vehicleDatabase.model.Vehicle;
import com.jsp.vehicleDatabase.service.VehicleService;



@RestController
public class VehicleController {
	
	
	@Autowired
	VehicleService service;
	
	//adding a vehicle
	@PostMapping("AddVehicle")
	public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle){
		return new ResponseEntity<Vehicle>(service.saveVehicle(vehicle),HttpStatus.CREATED);
	}
	
	//getting all data
	@GetMapping("Vehicles")
	public List<Vehicle> getvehicle(){
		return service.getVehicle();
	}
	//getting based on id
	@GetMapping("Vehicle/{id}")
	public ResponseEntity<Vehicle> getById(@PathVariable("id")int id){
		return new ResponseEntity<Vehicle>(service.getById(id),HttpStatus.OK);
	}
	
	//to get based on color
	@GetMapping("color/Silver")
	public List<Vehicle>getByColor(){
		return service.getByColor();
	}
	
	//sorted by price
	@GetMapping("Price/sorted/{pageNo}/{noOfRecords}")
	public List<Vehicle> getByPriceSorted(@PathVariable int pageNo,@PathVariable int noOfRecords){
		return service.getByPriceSorted(pageNo, noOfRecords);
	}
	
	//price more than 10,00,000
	@GetMapping("Price/MoreThan10lakh")
	public List<Vehicle> morethan10lakh(){
		return service.morethan10lakh();
	}
	
	//To Update based on Id
	@PutMapping("Update/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle,@PathVariable("id")int id){
		return new ResponseEntity<Vehicle>(service.updatevehicle(vehicle, id),HttpStatus.OK);
	}
	
	//To delete based on id
	@DeleteMapping("delete/{id}")
	public String deleteVehicle(@PathVariable("id")int id) {
		return service.DeleteVehicle(id);
	}
	
	

}
