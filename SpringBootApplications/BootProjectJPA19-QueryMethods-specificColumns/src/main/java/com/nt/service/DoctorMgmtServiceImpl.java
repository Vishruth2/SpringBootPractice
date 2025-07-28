package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public List<Object[]> showDoctorByIncome(double start, double end) {
		List<Object[]> list=docRepo.searchDoctorByIncome(start,end);
		return list;
	}

	

}
