package com.cognizant.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Query;
import com.cognizant.bloodbank.repository.QueryRepository;

@Service
public class QueryService {

	@Autowired
	QueryRepository queryRepository;
	
	public void addQuery(Query query){
		queryRepository.save(query);
	}
}
