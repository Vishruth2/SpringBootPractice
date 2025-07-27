package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public String registerDoctor(Doctor doctor);
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
	public boolean isDoctorAvailable(Integer Id);
	public long getDoctorsCount();
	public Iterable<Doctor> getAllDoctors();
	public Iterable<Doctor> getCustomersByIds(Iterable<Integer> ids);
	public String findTheDoctor(Integer id);
	public Doctor findDoctor(Integer id);
	public Doctor fetchTheDoctor(Integer id);
	public String adjustDoctorSalary(int id,double salaryBonus);
	public String registerOrUpdateDoctor(Doctor doc);
	public String removeDoctorById(int id);
	public String deleteDoctor(Doctor doctor);
	public String deleteAllDoctors();
	public String removeDoctorsByIds(List<Integer> ids);
	public String removeDoctorsByEntities(List<Integer> ids);
}
