package com.microservices.webservice.restfull.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.webservice.restfull.exceptions.UserNotFoundException;
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
	public EntityModel<User> getUserById(@PathVariable int id) {
		User user= userService.findById(id);
		if(user == null) 
			throw new UserNotFoundException("id :"+id);
		
		//Implementing HateOAS
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUserDetails());
		model.add(linkTo.withRel("all-users"));
	 
		return model;
	}
	
	//Insert Records
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		//This will set response as Created and status code as 201
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public String deleteById(@PathVariable int id )  {
		User deleteUser = userService.deleteById(id);
		if(deleteUser == null)
			return "No record found!";

		return "Record Deleted Successfully!";
	}
	
}
