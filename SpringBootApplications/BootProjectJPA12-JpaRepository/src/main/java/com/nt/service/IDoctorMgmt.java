package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmt {
	public String deleteDoctorsByIds(List<Integer> ids);
	public Doctor getCustomerById(int id); 
	public List<Doctor> showDoctorsByExampleData(Doctor doc,boolean ascOrder,String... props) ;
	public String groupDoctorsRegistration(List<Doctor> list);

}
