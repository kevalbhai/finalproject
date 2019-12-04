package com.cognizant.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.Query;
import com.cognizant.bloodbank.service.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController {

	@Autowired
	QueryService queryService;
	
	@PostMapping()
	public void addQuery(@RequestBody Query query){
		queryService.addQuery(query);
	}
}
