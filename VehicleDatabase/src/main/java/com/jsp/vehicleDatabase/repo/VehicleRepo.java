package com.jsp.vehicleDatabase.repo;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.vehicleDatabase.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	//to get based on color
	@Query(value="select * from vehicle where vcolor='Silver'",nativeQuery = true)
	List<Vehicle>getbyColor();
	
	//sorted by price
	@Query(value="select * from vehicle order by vprice",nativeQuery = true)
	List<Vehicle>getByPriceSorted(Pageable pageable);
	
	//Price more than 1000000
	@Query(value ="select * from vehicle where vprice >1000000",nativeQuery = true)
	List<Vehicle>morethan10lakh();
}
