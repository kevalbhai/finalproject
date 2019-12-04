package com.cognizant.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Experience;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.ExperienceRepository;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class ExperienceService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExperienceRepository experienceRepository;
	
	public void addExperience(String email, Experience experience){
		experienceRepository.save(experience);
		User user = userRepository.findByEmail(email);
		List<Experience> experienceList = user.getExperienceList();
		experienceList.add(experience);
		user.setExperienceList(experienceList);
		userRepository.save(user);
	}
	
	public List<Experience> getExperience(){
		return experienceRepository.findAll();
	}
}
