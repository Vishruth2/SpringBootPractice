package com.nt.services;

import com.nt.entity.Doctor;

public interface IDoctorManagementService {
	public Iterable<Doctor> getAllDoctor(boolean ascOrder,String...properties );
}
