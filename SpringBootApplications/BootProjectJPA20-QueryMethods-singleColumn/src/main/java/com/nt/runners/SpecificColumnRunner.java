package com.nt.runners;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class SpecificColumnRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			List<String> list=docService.showDoctorByIncome(10000.0, 1000000.0);
			
			//1.
			for (String doctorName: list) {
				System.err.println("Doctor Name :: "+doctorName);
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//2.
			list.stream().map(name -> "Doctor Name ::: "+name)
							.forEach(System.err::println);
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//3.
			List<String> formattedNames = list.stream()
				    .map(name -> "Doctor Name: " + name)
				    .toList();
			formattedNames.forEach(System.err::println);
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//4. These are extra (Showing Talent)
			   list.stream()
				    .map(name -> "Doctor Name: " + name)
				    .sorted()
				    .forEach(System.err::println);

			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//5. Using Maps just for practice and showing talent
			Map<String, Integer> nameLengthMap=list.stream().collect(Collectors.toMap(
					name->name,
					name->name.length()
					));
			nameLengthMap.forEach((name, length) -> 
		    System.err.println("Doctor: " + name + "\n Length: " + length));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
