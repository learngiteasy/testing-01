package com.rajnish.services;

import java.util.List;

import com.rajnish.binding.User;
import com.rajnish.entity.UserEntity;

public interface UserServices {

	public List<User> getListOfUsers();
	public String saveUser(User user);
	public User findByUserId(Integer userId);
	public String deleteUser(Integer userId);
	
}
