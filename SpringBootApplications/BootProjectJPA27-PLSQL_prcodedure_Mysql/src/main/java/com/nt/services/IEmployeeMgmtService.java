package com.nt.services;

import java.util.List;

import com.nt.entity.Employee_info;

public interface IEmployeeMgmtService {
	public List<Employee_info> showEmployeeBySalaryRange(double start,double end);
	public String saveEmployeeData(Employee_info info);
}
