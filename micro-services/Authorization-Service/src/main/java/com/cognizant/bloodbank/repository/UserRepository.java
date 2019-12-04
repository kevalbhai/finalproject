package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("from User u where u.email=?1")
	User findByEmail(String email);
}
