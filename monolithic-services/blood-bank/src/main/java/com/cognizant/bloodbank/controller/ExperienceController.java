package com.cognizant.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.Experience;
import com.cognizant.bloodbank.service.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

	@Autowired
	ExperienceService experienceService;
	
	@PostMapping("/{email}")
	public Boolean addExperience(@PathVariable("email") String email, @RequestBody Experience experience){
		experienceService.addExperience(email, experience);
		return true;
	}
	
	@GetMapping("")
	public List<Experience> getExperience(){
		return experienceService.getExperience();
	}
}
