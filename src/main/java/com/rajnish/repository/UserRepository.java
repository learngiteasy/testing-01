package com.rajnish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajnish.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
