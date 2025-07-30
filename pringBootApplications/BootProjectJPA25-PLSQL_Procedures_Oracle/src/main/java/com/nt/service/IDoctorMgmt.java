package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmt {
	public List<Doctor> showDoctorByIncomeRange(double start,double end);
}
