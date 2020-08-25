package com.microservices.webservice.restfull.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.microservices.webservice.restfull.repository.UserRepository;

@RestController
public class UserJPAResource {

	@Autowired 
	private UserRepository userRepository;
	
	// retrieve all user details 
	@GetMapping("/jpa/users")
	public List<User> getAllUserDetails(){

		return userRepository.findAll();
	}
		

	//Get records by Id
		@GetMapping("jpa/users/{id}")
		public EntityModel<User> getUserById(@PathVariable int id) {
			Optional<User> user= userRepository.findById(id);
			if(!user.isPresent()) 
				throw new UserNotFoundException("id :"+id);
			
			//Implementing HateOAS
			EntityModel<User> model = new EntityModel<>(user.get());
			WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUserDetails());
			model.add(linkTo.withRel("all-users"));
		 
			return model;
		}
		
}
