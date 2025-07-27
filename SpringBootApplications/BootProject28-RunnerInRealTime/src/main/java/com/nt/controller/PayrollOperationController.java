package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("payrollController")
public class PayrollOperationController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public List<Employee> showEmployeeByDesgs(String Desg1, String Desg2, String Desg3) throws Exception{
		
		List<Employee> list =service.fetchEmployeeDetailsByDesgs(Desg1, Desg2, Desg3);
		return list;
	}
}
