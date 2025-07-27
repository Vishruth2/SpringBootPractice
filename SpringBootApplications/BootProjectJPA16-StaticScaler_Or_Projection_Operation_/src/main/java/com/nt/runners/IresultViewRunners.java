package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;

@Component
public class IresultViewRunners implements CommandLineRunner {
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public void run(String... args) throws Exception {
		try {
			docRepo.findBySpecializationIn(List.of("Mentalist","Cardiologist")).forEach(doc->{
				System.err.println(doc.getDocName()+"--------------------------------"+doc.getDocId());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
