package com.cognizant.bloodbank.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.model.Role;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.RoleRepository;
import com.cognizant.bloodbank.repository.UserRepository;


@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	public boolean signup(User user) throws UserAlreadyExistsException{
		User users = userRepository.findByEmail(user.getEmail());
		System.out.println("++++++++++++++++++++++++++++++++++IN UDS++++++++++++++++++++++++++++++++++++");
		if(users != null){
			throw new UserAlreadyExistsException("Email already exists");
			
		}
		else{
			System.out.println("IN ELSE UDS");
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			Set<Role> roleSet = new HashSet<>();
			Role role = roleRepository.findById(1).get();
			roleSet.add(role);
			user.setRoleList(roleSet);
			userRepository.save(user);
			return true;
		}
	
	}
}
