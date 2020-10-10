package com.newproject.newolaversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newproject.newolaversion.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{

	public  Driver findByEmail(String email);

	public Driver findByContactNumber(String contactNumber);

	public List<Driver> findByStatus(String status);

	//@Query("SELECT d.firstName, d.lastName, u.firstName, u.lastName, u.email, u.password, u.phoneNo, u.date FROM com.newproject.newolaversion.model.Driver d JOIN com.newproject.newolaversion.model.User u ON d.firstName=u.firstName")
	@Query("SELECT d.firstName, d.lastName, u.firstName, u.lastName, u.email, u.password, u.phoneNo, u.date FROM Driver d INNER JOIN User u ON u.id = d.id")
	public Object[] findByTwoTable();
	

 
}
