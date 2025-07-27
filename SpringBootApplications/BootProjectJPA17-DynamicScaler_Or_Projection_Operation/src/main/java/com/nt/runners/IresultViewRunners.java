package com.nt.runners;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.view.IResultView;
import com.nt.view.IResultView1;

@Component
public class IresultViewRunners implements CommandLineRunner {
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public void run(String... args) throws Exception {
		try {
			StreamSupport.stream(docRepo.findByIncomeBetween(10000.0, 60000.0,IResultView.class).spliterator(), false)
			                     .forEach(doc->{
			                    	 System.err.println(doc.getDocId()+"------------------------------"+doc.getDocName());
			                     });
			System.out.println("=========================================="
					+ "==================================================== "
					+ "====================================================");
			
			StreamSupport.stream(docRepo.findByIncomeBetween(10000.0, 60000.0,IResultView1.class).spliterator(), false)
			.forEach(doc->{
           	 System.err.println(doc.getDocId()+"---------------------"+doc.getSpecialization()+"---------------------------"+doc.getIncome());
            });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
