package com.nt.runners;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class FindXXXrunners implements CommandLineRunner {
	
	@Autowired
	private IDoctorRepository docRepo;

	
	@Override
	public void run(String... args) throws Exception {
		StreamSupport.stream(docRepo.findByDocNameStartingWith("s").spliterator(), false)
							 .forEach(System.err::println);
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		StreamSupport.stream(docRepo.findByDocNameEndingWith("n").spliterator(), false)
		                      .forEach(System.err::println);
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		StreamSupport.stream(docRepo.findByDocNameContaining("a").spliterator(), false)
		                      .forEachOrdered(System.err::println);
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		StreamSupport.stream(docRepo.findByDocNameEqualsIgnoreCase("VISHruth VaRDHaN").spliterator(), false)
							 .forEach(System.err::println);
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
//		StreamSupport.stream(docRepo.findByContainingIgnoreCase("uT").spliterator(), false)
//							 .forEach(System.err::println);
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		StreamSupport.stream(docRepo.findByDocNameLike("V%").spliterator(), false)
		 .forEach(System.err::println);
		
		StreamSupport.stream(docRepo.findByDocNameLike("%V%").spliterator(), false)
		 .forEach(System.err::println);
		
		StreamSupport.stream(docRepo.findByDocNameLike("%V").spliterator(), false)
		 .forEach(System.err::println);
		
		StreamSupport.stream(docRepo.findByDocNameLike("____").spliterator(), false)
		 .forEach(System.err::println);

		
		
	}

}
