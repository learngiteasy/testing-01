package com.rajnish.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajnish.entity.Country;
import com.rajnish.repository.CountryRepository;

@RestController
public class CountryController {

	@Autowired
	private CountryRepository countryRepo;
	@GetMapping("/countryrecord")
	public Map<Integer,String> getCountry(){
		List<Country> findAll = this.countryRepo.findAll();
		
		Map<Integer,String> countryMap=new HashMap();
		
		for(Country ob:findAll) {
			countryMap.put(ob.getCountryId(), ob.getCountryName());
		}
		System.out.println(countryMap);
		return countryMap;
		
	}
	
	
//	@GetMapping("/countryrecord")
//	public List<Country> getCountry(){
//		List<Country> findAll = this.countryRepo.findAll();
//		
////		Map<Integer,String> countryMap=new HashMap();
////		
////		for(Country ob:findAll) {
////			countryMap.put(ob.getCountryId(), ob.getCountryName());
////		}
////		System.out.println(countryMap);
//		return findAll;
//		
//	}
}
