package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmt;

@Component
public class PLSQLRunners implements CommandLineRunner {
	
	@Autowired
	private IDoctorMgmt dservice;

	@Override
	public void run(String... args) throws Exception {
		try {
			//invoke the method 
			dservice.showDoctorByIncomeRange(10000.0,1000000.0).forEach(System.err::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
