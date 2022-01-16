package com.rajnish;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.rajnish.binding.User;
import com.rajnish.entity.UserEntity;
import com.rajnish.repository.UserRepository;

@SpringBootTest
class SpringbootCrudThymeleaf01ApplicationTests {

	private UserRepository userRepo;
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void getAllUsers() {
		List<UserEntity> findAll = this.userRepo.findAll();
		List<User> target =new ArrayList();
		System.out.println(findAll);
		
		BeanUtils.copyProperties(findAll, target);
		System.out.println(target);
	}

}
