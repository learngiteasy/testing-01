package com.rajnish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="First_Name",length=100)
	private String firstName;
	
	@Column(name="Last_Name",length=100)
	private String lastName;
	
	@Column(name="Email_Id",length=100,unique=true)
	private String emailId;
	
	@Column(name="Country_Name",length=100)
	private String countryName;
	
	@Column(name="gender",length=100)
	private String gender;
	
	
	
}
