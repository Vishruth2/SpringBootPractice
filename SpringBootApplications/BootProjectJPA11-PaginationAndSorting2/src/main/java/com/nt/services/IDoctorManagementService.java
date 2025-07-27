package com.nt.services;



import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorManagementService {
	public Iterable<Doctor> getAllDoctor(boolean ascOrder,String...properties );
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo,int pageSize,boolean ascOrder,String properties);
	public void showDoctorPageByPage(int pageSize);
}
