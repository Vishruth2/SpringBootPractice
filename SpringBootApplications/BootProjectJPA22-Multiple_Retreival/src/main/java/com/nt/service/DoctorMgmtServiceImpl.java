package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public Doctor searchDoctorByDocName(String docName) {
		Doctor d=docRepo.showDoctorInfoByName(docName).orElseThrow(()-> new IllegalArgumentException("Invalid Doctor Name "));
		return d;
	}

	@Override
	public List<Object[]> searchDoctorBySpecialization(String specials) {
		List<Object[]> list = docRepo.showDoctorInforBySpecialization(specials);
		return list;
	}

	@Override
	public List<String> searchDoctorNameBySpecialization(String specials) {
		List<String> list = docRepo.showDoctorNameBySpecialization(specials);
		return list;
	}


	

	

}
