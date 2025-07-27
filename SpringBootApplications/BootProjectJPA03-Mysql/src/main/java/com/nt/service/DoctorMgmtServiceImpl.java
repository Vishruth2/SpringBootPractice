package com.nt.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service("docService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.err.println(doctor);
		Doctor doc=doctorRepo.save(doctor);
		return "Doctor record is inserted Succesfully :: "+doc;
	}

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
	    if (doctors != null) {
	        Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);

//	        // Convert Iterable to Stream and process
//	        String result=StreamSupport.stream(savedDoctors.spliterator(), false)
//	                              .map(doc-> "Doctor with ID "+doc.getDocId()+" saved.")// Use actual method names
//	                              .collect(Collectors.joining("\n")); //join messages into single string
	        //but prefer this not below one
//	        return result;
	        
	        /**/
	        
	        int size = ((Collection) savedDoctors).size();
	        List<Integer> ids = (List<Integer>) ((Collection<Doctor>) savedDoctors).stream()
	                            .map(d -> ((Doctor) d).getDocId())
	                            .collect(Collectors.toList());

	        return size + " doctors are saved with ID values: " + ids.toString();

	   
	    }
	    return "No doctors provided";
	}

}
