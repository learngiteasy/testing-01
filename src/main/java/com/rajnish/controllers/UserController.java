package com.rajnish.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rajnish.binding.User;
import com.rajnish.entity.Country;
import com.rajnish.repository.CountryRepository;
import com.rajnish.services.UserServices;

@Controller
public class UserController {

	
	
	@Autowired
	private UserServices userService;
	@GetMapping("/")
	public String getAllUser(Model model) {
	
		 List<User> listOfUsers = this.userService.getListOfUsers();
	     model.addAttribute("users", listOfUsers);
		 return "index";
	}
	
	@GetMapping("/showemployeeform")
	public String showEmployeeForm(Model model) {
		User ob=new User();
		model.addAttribute("user",ob );
		return "add-user";
	}
	
	@PostMapping("/saveemployee")
	public String saveUser(User user) {
		 if(user.getCountryName().equals("-1")) {
			 int i=user.getUserId();
				return "redirect:/showeditform/"+i;
	}
		 else {
		 String saveUser = this.userService.saveUser(user);
		 System.out.println(user);
		return saveUser;
		 }
			 
		
	}
	
	@GetMapping("/showeditform/{id}")
	public String showEditForm(@PathVariable Integer id,Model model) {
		 User user = this.userService.findByUserId(id);
		 model.addAttribute("user", user);
		 return "show-edit-form";
	}
	@GetMapping("/deleterecord/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return this.userService.deleteUser(id);
	}
	
}
