package com.microservices.webservice.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.webservice.restfull.pojo.User;
import com.microservices.webservice.restfull.pojo.UserDaoService;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userService;

	
	// retrieve all user details 
	@GetMapping("/users")
	public List<User> getAllUserDetails(){

		return userService.getAllRecords();
	}
	
	//Get records by Id
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {

		return userService.findById(id);
	}

}
