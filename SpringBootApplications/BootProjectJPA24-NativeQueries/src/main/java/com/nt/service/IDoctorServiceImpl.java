package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IDoctorRepository;

import lombok.NonNull;

@Service
public class IDoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public String insertDoctor(String name, String special, double income) {
		int count=docRepo.registerDoctor(name, special, income);
		return count==0?"Doctor is not registered":"Doctor is registered";
	}

	@Override
	public String showSystemDate() {
		return docRepo.showSystemDate();
	}

	@Override
	public String createTempDBtable() {
		int created=docRepo.createTempoTable();
		return created==0?"Table is created in Database":"Table is not created in Database";
	}
	
	
	


}
