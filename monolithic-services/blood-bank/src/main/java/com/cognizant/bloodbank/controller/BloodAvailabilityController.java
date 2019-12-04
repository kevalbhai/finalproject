package com.cognizant.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.service.BloodAvailabilityService;

@RestController
@RequestMapping("/availability")
public class BloodAvailabilityController {

	@Autowired
	BloodAvailabilityService bloodAvailabilityService;	
	
	@PostMapping
	public List<User> getBloodAvailability(@RequestBody BloodRequirement bloodRequirement){
		System.out.println("+++"+bloodRequirement);
		return bloodAvailabilityService.getBloodAvailability(bloodRequirement);
	}
}
