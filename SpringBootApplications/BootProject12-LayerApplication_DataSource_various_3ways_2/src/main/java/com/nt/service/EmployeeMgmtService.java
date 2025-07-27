package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	@Override
	public List<Employee> fetchEmployeeDetailsByDesgs(String Desg1, String Desg2, String Desg3) throws Exception {
		List<Employee> list=empDAO.getEmployeeByDesgs(Desg1, Desg2, Desg3);
		return list;
	}

}
