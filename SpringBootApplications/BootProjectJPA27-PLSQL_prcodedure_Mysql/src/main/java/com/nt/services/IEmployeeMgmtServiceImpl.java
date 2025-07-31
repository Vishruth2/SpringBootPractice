package com.nt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_info;
import com.nt.repo.IEmployeeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
/*
 * 
 * USE `ntspbms716db`;
DROP procedure IF EXISTS `p_emp_details_by_salaryRange`;

DELIMITER $$
USE `ntspbms716db`$$
CREATE PROCEDURE `p_emp_details_by_salaryRange` (in startSalary float,in endSalary float )
BEGIN
	select * from employee_info where sal>=startSalary and sal<=endSalary; 
END$$

DELIMITER ;
 * */

@Service
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepo repo;
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee_info> showEmployeeBySalaryRange(double start, double end) {
		//create StoredProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("p_emp_details_by_salaryRange", Employee_info.class);
		//register the parameter of the stored procedure
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		//set parameter values
		query.setParameter(1, start);
		query.setParameter(2, end);
		//call PL/SQL procedure
		List<Employee_info> list=query.getResultList();

		return list;
	}

	@Override
	public String saveEmployeeData(Employee_info info) {
		Integer id=repo.save(info).getEno();
		return "Employee info is saved with :"+id;
	}

}
