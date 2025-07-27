package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.BootProjectJPA08_Delete_Operation;
import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service("docService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

    private final BootProjectJPA08_Delete_Operation bootProjectJPA08_Delete_Operation;

	@Autowired
	private IDoctorRepository doctorRepo;
	private Optional<Doctor>  doc;

    DoctorMgmtServiceImpl(BootProjectJPA08_Delete_Operation bootProjectJPA08_Delete_Operation) {
        this.bootProjectJPA08_Delete_Operation = bootProjectJPA08_Delete_Operation;
    }
	
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

	@Override
	public boolean isDoctorAvailable(Integer Id) {
		boolean isDocAvail = doctorRepo.existsById(Id);
		return isDocAvail;
	}

	@Override
	public long getDoctorsCount() {
		long count = doctorRepo.count();
		return count;
	}

	@Override
	public Iterable<Doctor> getAllDoctors() {
		Iterable<Doctor> it=doctorRepo.findAll();
		return it;
	}

	@Override
	public Iterable<Doctor> getCustomersByIds(Iterable<Integer> ids) {
		Iterable<Doctor> it=doctorRepo.findAllById(ids);
		return it;
	}

	@Override
	public String findTheDoctor(Integer id) {
		Optional<Doctor> doc = doctorRepo.findById(id);
		if (doc.isPresent()) {
			return "id :"+id+" Customer "+doc.get();
		} else {
			return "Customer not found!!!!";
		}
	}

//	@Override
//	public Doctor findDoctor(Integer id) {
//		Optional<Doctor> opt = doctorRepo.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		} else {
//			throw  new IllegalArgumentException("Doctor not found");
//		}
//	}
	
	@Override
	public Doctor findDoctor(Integer id) {
		return  doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Doctor not found"));
		
	}

	@Override
	public Doctor fetchTheDoctor(Integer id) {
		return doctorRepo.findById(id).orElse(new Doctor());
		// docId=953, docName=Lenardo Da vinci, specialization=Neurologist, salary=150000.0)
	}

	@Override
	public String adjustDoctorSalary(int id, double salaryBonus) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if (opt.isPresent()) {
			Doctor doc = opt.get();
			//calculate bonus amount
			double bonus = doc.getSalary()+((doc.getSalary()*salaryBonus)/100);
			//set bonus to doctor
			doc.setSalary(bonus);
			//update in table
			doctorRepo.save(doc);
			return id+"Doctor salary got updated";
		} 
		return id+"Doctor with that id is not found";
	}

	@Override
	public String registerOrUpdateDoctor(Doctor inputDoctor) {
	    Optional<Doctor> optional = doctorRepo.findById(inputDoctor.getDocId());
	    if (optional.isPresent()) {
	        // Existing doctor found — update the managed entity
	        Doctor existingDoctor = optional.get();
	        existingDoctor.setDocName(inputDoctor.getDocName());
	        existingDoctor.setSpecialization(inputDoctor.getSpecialization());
	        existingDoctor.setSalary(inputDoctor.getSalary());

	        doctorRepo.save(existingDoctor); // Save managed entity
	        return "Doctor with ID " + existingDoctor.getDocId() + " updated successfully.";
	    } else {
	        // New doctor — let DB generate ID
	        inputDoctor.setDocId(null); // Ensure new insert
	        Doctor saved = doctorRepo.save(inputDoctor);
	        return "New Doctor registered with ID " + saved.getDocId();
	    }
	}

	@Override
	public String removeDoctorById(int id) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if (opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id+"is Deleted  successfully ";
		} else {
			return id+" is not found for deleted";
		}
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		//Load the object
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isEmpty()) {
			return doctor.getDocId()+" doctor is not found";
		} else {
			doctorRepo.delete(opt.get());
			return doctor.getDocId()+" doctor is deleted";
		}
		
	}

	@Override
	public String deleteAllDoctors() {
		//get the doctors count wheather are they are not
		long count=doctorRepo.count();
		if (count>0) {
			doctorRepo.deleteAll();
			return count+"no of total records are found and deleted";
		} else {
			return "No records are found and deleted";
		}
	}

	@Override  
	public String removeDoctorsByIds(List<Integer> ids) {  
//	    List<Doctor> doctors = StreamSupport.stream(  
//	            doctorRepo.findAllById(ids).spliterator(),  
//	            false  
//	        )  
//	        .collect(Collectors.toList());  

	    if (ids.isEmpty()) {  
	        return "No doctors found with the provided IDs.";  
	    }  

	    doctorRepo.deleteAllById(ids); // Bulk deletion  
	    return ids.size() + " doctor(s) removed successfully.";  
	}

	@Override
	public String removeDoctorsByEntities(List<Integer> ids) {
		List<Doctor> doctors =StreamSupport.stream(doctorRepo.findAllById(ids).spliterator(), false) //doctorRepo.findAllById(ids) returns iterable 
							 .collect(Collectors.toList());
		
		if (doctors.isEmpty()) {
			return "No doctors found with the provided IDs.";  
		}
		doctorRepo.deleteAll(doctors);
		return doctors.size()+"doctors removed successfully";
	}

}
