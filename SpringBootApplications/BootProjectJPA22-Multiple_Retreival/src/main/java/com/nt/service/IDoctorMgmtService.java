package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public Doctor searchDoctorByDocName(String docName);
	public List<Object[]> searchDoctorBySpecialization(String specials);
	public List<String> searchDoctorNameBySpecialization(String specials);
}
