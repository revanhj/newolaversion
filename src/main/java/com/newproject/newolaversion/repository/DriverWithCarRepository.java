package com.newproject.newolaversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.newolaversion.model.DriverWithCar;

public interface DriverWithCarRepository extends JpaRepository<DriverWithCar, Integer>{

	DriverWithCar findByEmail(String email);

	DriverWithCar findByContactNumber(String contactNumber);

	List<DriverWithCar> findByStatus(String status);

 
}
