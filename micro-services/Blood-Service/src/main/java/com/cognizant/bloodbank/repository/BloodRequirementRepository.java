package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.BloodRequirement;

@Repository
public interface BloodRequirementRepository extends JpaRepository<BloodRequirement, Integer>{

}
