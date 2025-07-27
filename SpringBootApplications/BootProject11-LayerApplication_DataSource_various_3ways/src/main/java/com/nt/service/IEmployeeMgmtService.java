package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmployeeDetailsByDesgs(String Desg1,String Desg2,String Desg3) throws Exception;
}
