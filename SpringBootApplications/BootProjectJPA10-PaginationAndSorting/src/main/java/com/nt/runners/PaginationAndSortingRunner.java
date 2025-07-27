package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.services.IDoctorManagementService;

@Component
public class PaginationAndSortingRunner implements CommandLineRunner {

	@Autowired
	private IDoctorManagementService dservice;
	@Override
	public void run(String... args) throws Exception {
		dservice.getAllDoctor(true, "income").forEach(System.out::println);

	}

}
