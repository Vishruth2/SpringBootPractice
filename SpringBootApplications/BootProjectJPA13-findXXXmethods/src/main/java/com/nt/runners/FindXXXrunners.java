package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;

@Component
public class FindXXXrunners implements CommandLineRunner {
	
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("findByXXX methods equals");
		docRepo.findByDocNameEquals("Vishruth vardhan").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.findByDocName("Monica Belluci").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.findByDocNameIs("Srikar Varaprasad").forEach(System.err::println);
		
		System.err.println("getByXXX methods equals");
		docRepo.getByDocNameEquals("Vishruth vardhan").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.getByDocName("Monica Belluci").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.getByDocNameIs("Srikar Varaprasad").forEach(System.err::println);
		
		System.err.println("readByXXX methods equals");
		docRepo.readByDocNameEquals("Vishruth vardhan").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.readByDocName("Monica Belluci").forEach(System.err::println);
		System.err.println("________________________________________________________________");
		docRepo.readByDocNameIs("Srikar Varaprasad").forEach(System.err::println);
		
	}

}
