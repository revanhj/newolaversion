package com.newproject.newolaversion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "userwithcar")
public class DriverWithCar {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String cPhoto1;
	private String cPhoto2;
	private String cPhoto3;
	private String cDocument1;
	private String cDocument2;
	private String cDocument3;
	private String cDocument4;
	private String condition;
	private String contactNumber;
	private String status;

}
