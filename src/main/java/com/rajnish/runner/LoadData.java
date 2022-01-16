package com.rajnish.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rajnish.entity.Country;
import com.rajnish.repository.CountryRepository;
import com.rajnish.repository.UserRepository;

@Component
public class LoadData implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO code to load the data form the database
		// It is for master table only
		Country c1=new Country();
		c1.setCountryId(1);
		c1.setCountryName("India");
		Country c2=new Country();
		c2.setCountryId(2);
		c2.setCountryName("Japan");
		Country c3=new Country();
		c3.setCountryId(3);
		c3.setCountryName("America");
		
		Country c4=new Country();
		c4.setCountryId(4);
		c4.setCountryName("Russia");
		List<Country> list=new ArrayList();
		
		list.add(c1);list.add(c2);list.add(c3);
		
		// sending the dta to database
		this.countryRepo.saveAll(list);
	}

}
