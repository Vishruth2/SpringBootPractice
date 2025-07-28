package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class QueryRunners implements CommandLineRunner {
	
	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			docService.showDoctorByIncomeRange(10000.0, 200000.0).forEach(System.err::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
