package com.rajnish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajnish.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {

}
