package com.cognizant.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class BloodAvailabilityService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getBloodAvailability(BloodRequirement bloodRequirement){
		System.out.println(bloodRequirement+"---------------------------------------------");
		List<User> users = userRepository.findByBloodgroupAndPincode(bloodRequirement.getBloodgroup(), bloodRequirement.getPincode());
				//userRepository.bloodAvailability(bloodRequirement.getBloodgroup(), bloodRequirement.getPincode());
		System.out.println(users);
		for (User user : users) {
			user.setPassword(null);
			user.setBloodrequireList(null);
			user.setRoleList(null);
			user.setExperienceList(null);
			user.setAge(0);
			user.setEmail(null);
			user.setGender(null);
			user.setWeight(0);
		}
		return users;
	}
}
