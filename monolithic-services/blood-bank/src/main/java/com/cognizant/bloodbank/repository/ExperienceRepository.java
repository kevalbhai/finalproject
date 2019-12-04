package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

	@Query("from Experience e order by id desc")
	List<Experience> findAll();
}
