package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_info;
import com.nt.services.IEmployeeMgmtService;

@Component
public class CallingPLSQLProceduresRunners implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService eservice;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//inserting data into table
//			String result=eservice.saveEmployeeData(new Employee_info("Tyler Durden", "Manager", 60000.0, 75000.0, 67000.0));
//			System.err.println(result);
//			String result2 = eservice.saveEmployeeData(new Employee_info("Marla Singer", "HR", 48000.0, 59000.0, 54000.0));
//			String result3 = eservice.saveEmployeeData(new Employee_info("Robert Paulson", "Developer", 45000.0, 58000.0, 52000.0));
//			String result4 = eservice.saveEmployeeData(new Employee_info("Angel Face", "Intern", 15000.0, 18000.0, 16000.0));
//			String result5 = eservice.saveEmployeeData(new Employee_info("Big Bob", "Architect", 70000.0, 85000.0, 77000.0));
//			String result6 = eservice.saveEmployeeData(new Employee_info("Richard Chesler", "Team Lead", 55000.0, 69000.0, 62000.0));
//			String result7 = eservice.saveEmployeeData(new Employee_info("Narrator", "Tester", 40000.0, 51000.0, 46000.0));
//			String result8 = eservice.saveEmployeeData(new Employee_info("Irvin Kestrel", "Clerk", 25000.0, 30000.0, 27000.0));
//			String result9 = eservice.saveEmployeeData(new Employee_info("Chloe", "Designer", 42000.0, 53000.0, 48000.0));
//			String result10 = eservice.saveEmployeeData(new Employee_info("Mechanic Mike", "Maintenance", 30000.0, 36000.0, 32000.0));
//			  List<String> results = List.of( result2, result3, result4, result5,
//                      result6, result7, result8, result9, result10);
//			  
//			  System.err.println(results);
			
			eservice.showEmployeeBySalaryRange(20000.0, 70000.0).forEach(emp -> {
			    System.err.println("Employee ID			: " + emp.getEno());
			    System.err.println("Name					: " + emp.getEname());
			    System.err.println("Designation 			: " + emp.getDesg());
			    System.err.println("Salary  				: " + emp.getSalary());
			    System.err.println("Gross Salary			: " + emp.getGross_salary());
			    System.err.println("Net Salary 			: " + emp.getNet_salary());
			    System.err.println("--------------------------------------------------------------------");
			});


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
