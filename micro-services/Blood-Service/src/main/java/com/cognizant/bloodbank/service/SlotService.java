package com.cognizant.bloodbank.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.SlotRepository;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class SlotService {
	
	@Autowired
	SlotRepository slotRepository;
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public Boolean addSlot(Slot slot, String email){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date_angular = df.format(slot.getDate());
		User user = userRepository.findByEmail(email);
		List<Slot> slotList = slotRepository.findByHospitalname(slot.getHospitalname());
		for (Slot slot2 : slotList) {
			String date_sql = df.format(slot2.getDate());
			if(date_angular.equals(date_sql)){
				if(slot.getTime().equals(slot2.getTime())){
					return false;
				}
			}
		}
		slot.setUser_id(user.getId());
		slotRepository.save(slot);
		return true;
	}
}
