package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer>{

	List<Slot> findByHospitalname(String hospitalname);

}
