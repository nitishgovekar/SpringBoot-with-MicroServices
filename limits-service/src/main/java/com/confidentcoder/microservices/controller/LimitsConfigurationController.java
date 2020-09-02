package com.confidentcoder.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confidentcoder.microservices.beans.LimitsConfiguration;

@RestController

public class LimitsConfigurationController {

	@GetMapping("/limits")
	public LimitsConfiguration  retrieveLimitsConfigurations() {
		
		return new LimitsConfiguration(1000, 1);
	}
}
