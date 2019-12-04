package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer>{

}
