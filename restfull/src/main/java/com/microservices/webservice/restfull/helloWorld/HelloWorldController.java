package com.microservices.webservice.restfull.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//Return HelloWorld text
	@GetMapping(path="/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/helloWorldBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Welcome to Spring Boot");
	}
	//How to use Path Variable
	@GetMapping("/helloWorld/getName/{firstName}")
	public HelloWorldBean  getMyName(@PathVariable String firstName) {

		return new HelloWorldBean(firstName);
	}
	
}
