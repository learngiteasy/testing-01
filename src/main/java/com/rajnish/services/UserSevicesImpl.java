package com.rajnish.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rajnish.binding.User;
import com.rajnish.entity.UserEntity;
import com.rajnish.exception.UserErrorException;
import com.rajnish.exception.UserHandleException;
import com.rajnish.repository.UserRepository;

@Service
public class UserSevicesImpl implements UserServices {

	@Autowired
	private UserHandleException userException;
	@Autowired
	private UserRepository userRepo;
	@Override
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> findAll = (List<UserEntity>)this.userRepo.findAll();
		List<User> target =new ArrayList();
		//System.out.println(findAll);
		for(UserEntity ob:findAll) {
			User user=new User();
			BeanUtils.copyProperties(ob, user);
			target.add(user);
		}
	
		//System.out.println(target);
		//model.addAttribute("users", target);
		return target;
	}

	@Override
	public String saveUser(User user) {
		String mesg="";
		try {
			
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity save = this.userRepo.save(userEntity);
		if(save==null) {
			throw new UserErrorException();
		}
		else {
			mesg="redirect:/";
		}
		}catch(Exception ex) {
			this.userException.handleException();
		}
		
		return mesg;
	}

	

	@Override
	public String deleteUser(Integer userId) {
		this.userRepo.deleteById(userId);
		return "redirect:/";
	}

	@Override
	public User findByUserId(Integer userId) {
		Optional<UserEntity> findById = this.userRepo.findById(userId);
		  User ob1=new User();
		  
		try {
			if(findById.isPresent()) {
				UserEntity userEntity = findById.get();
				BeanUtils.copyProperties(userEntity,ob1);
			}
			else {
				throw new UserErrorException("Error occures");
			}
		}catch(Exception ex) {
			this.userException.handleException();
		}
		return ob1;
	}

}
