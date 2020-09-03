package com.confidentcoder.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confidentcoder.microservices.beans.Configuration;
import com.confidentcoder.microservices.beans.LimitsConfiguration;

@RestController

public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration  retrieveLimitsConfigurations() {
		
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
