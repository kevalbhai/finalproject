package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
