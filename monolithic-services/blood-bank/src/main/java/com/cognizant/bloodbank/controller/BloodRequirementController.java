package com.cognizant.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.service.BloodRequirementService;

@RestController
@RequestMapping("/bloodrequire")
public class BloodRequirementController {

	@Autowired
	BloodRequirementService bloodRequirementService;
	
	@PostMapping("/{email}")
	public Boolean addBloodRequirement(@PathVariable String email, @RequestBody BloodRequirement bloodRequirement){
		System.out.println(email+"--------------"+bloodRequirement);
		bloodRequirementService.addBloodRequirement(email, bloodRequirement);
		return true;
	}
	
	@GetMapping("")
	public List<BloodRequirement> getBloodRequirement(){
		return bloodRequirementService.getBloodRequirement();
	}
	
}
