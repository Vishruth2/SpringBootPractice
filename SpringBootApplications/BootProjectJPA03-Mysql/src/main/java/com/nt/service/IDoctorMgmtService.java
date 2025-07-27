package com.nt.service;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public String registerDoctor(Doctor doctor);
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
}
