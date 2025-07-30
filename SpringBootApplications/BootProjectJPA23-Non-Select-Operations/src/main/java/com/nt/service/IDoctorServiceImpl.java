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
	public int appraiseDoctorsIncomeBySpecialization(@NonNull String specialization, double hikePercentage) {
		int count=docRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
		return count;
	}

	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return docRepo.removeDoctorByIncomeRange(start, end);
	}

}
