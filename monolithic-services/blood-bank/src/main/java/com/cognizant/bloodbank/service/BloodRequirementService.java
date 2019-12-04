package com.cognizant.bloodbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.BloodRequirementRepository;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class BloodRequirementService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BloodRequirementRepository bloodRequirementRepository;
	
	@Transactional
	public void addBloodRequirement(String email, BloodRequirement bloodRequirement){
		User user = userRepository.findByEmail(email);
		bloodRequirementRepository.save(bloodRequirement);
		List<BloodRequirement> bloodrequireList = user.getBloodrequireList();
		bloodrequireList.add(bloodRequirement);
		user.setBloodrequireList(bloodrequireList);
		userRepository.save(user);		
	}
	
	@Transactional
	public List<BloodRequirement> getBloodRequirement(){
		List<BloodRequirement> bloodRequireList = bloodRequirementRepository.findAll();
		return bloodRequireList;
	}
}
