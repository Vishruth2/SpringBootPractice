package com.nt.runners;

import java.util.List;
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
		StreamSupport.stream(docRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(100000.0, 300000.0).spliterator(), false)
		                      .forEach(System.out::println);
		
		StreamSupport.stream(docRepo.findBySpecializationInAndIncomeBetween(List.of("Mentalist","physician"), 10000, 60000).spliterator(), false)
							  .forEach(doc-> System.err.println(doc));
		
		
	}

}
