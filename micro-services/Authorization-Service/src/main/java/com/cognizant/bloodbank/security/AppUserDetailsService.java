package com.cognizant.bloodbank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user==null)
			throw new UsernameNotFoundException("User Not Present");
		else{
			AppUser appUser = new AppUser(user);
			return appUser;
		}
	}
	
}
