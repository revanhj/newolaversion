package com.newproject.newolaversion.model;

import java.util.Date;

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
@Entity(name = "carowner")
public class Car {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	private String carOwnerName;
	private String carOwnerEmail;
	private String carOwnerContactNo;
 	private String carOwnerPassword;
    private Date date;
    private String status;
	private Date createdAt;
	private Date updatedAt;
	
}
