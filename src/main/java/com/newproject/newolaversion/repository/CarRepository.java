package com.newproject.newolaversion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.newolaversion.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	public Car findByCarOwnerEmail(String email);
    public List<Car> findByStatus(String status);

}
