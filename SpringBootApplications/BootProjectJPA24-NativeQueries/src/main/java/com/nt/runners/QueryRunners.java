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
			System.err.println("______________native SQL Queries ___________________");
			System.err.println(dservice.insertDoctor("Sonia Singh", "Gynaceologist", 100000.0));
			
			System.err.println("System Date Time ::: "+dservice.showSystemDate());
			System.err.println(dservice.createTempDBtable());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
