package com.cognizant.bloodbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.service.SlotService;

@RestController
@RequestMapping("/slotbooking")
public class SlotController {

	@Autowired
	SlotService slotService;
	
	@PostMapping("/{email}")
	public Boolean addSlot(@RequestBody Slot slot, @PathVariable String email){
		System.out.println("in controller"+slot);
		return slotService.addSlot(slot, email);
		
	}
}
