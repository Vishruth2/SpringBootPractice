package com.nt.service;

public interface IDoctorService {
	public int appraiseDoctorsIncomeBySpecialization(String specialization,double hikePercentage);
	public int fireDoctorsByIncomeRange(double start,double end);
}
