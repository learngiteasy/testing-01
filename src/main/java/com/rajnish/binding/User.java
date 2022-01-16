package com.rajnish.binding;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
public class User {

	
	private int userId;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String emailId;
	
	
	private String countryName;
	
	
	private String gender;
	
	
	
}

