package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorService;

@Component
public class QueryRunners implements CommandLineRunner {
	
	@Autowired
	private IDoctorService dservice;

	@Override
	public void run(String... args) throws Exception {
	try {
		System.err.println("++++++++++++++++++++++Non-Select Operations+++++++++++++++++++++++++++++");
		int count =dservice.appraiseDoctorsIncomeBySpecialization("Mentalist", 10.0);
		System.err.println("No of records that are affected :: "+count);

		System.err.println("Deleted Doctors count :: "+dservice.fireDoctorsByIncomeRange(10000.0, 60000.0));
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
