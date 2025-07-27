package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service("doctorService")
public class IDoctorMgmtImpl implements IDoctorMgmt {
	@Autowired
	private IDoctorRepository docRepo;

	@Override
	public String deleteDoctorsByIds(List<Integer> ids) {
		List<Doctor> list=docRepo.findAllById(ids);
		/**
		 * if you see findAllById takes null also if you don't have that id it will ignore 
		 * but when you send parameter as iterable like list class List.of() this doesn't allow null value
		 * 
		 * */
		if (list.size()!=0) {
			docRepo.deleteAllById(ids);
			return list.size()+" no of records are deleted ";
		} 
		return "No records are found for deletion";
	}

	@Override
	public Doctor getCustomerById(int id) {
//		Doctor d1= docRepo.getById(id); Depricated
//		Doctor d2= docRepo.getOne(id); Depricated
		
		Doctor doc=docRepo.getReferenceById(id);
		return doc;
	}

	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor doc, boolean ascOrder, String... props) {
		Example<Doctor> example = Example.of(doc);
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		List<Doctor> docs = docRepo.findAll(example, sort);
		return docs;
	}

	@Override
	public String groupDoctorsRegistration(List<Doctor> list) {
		List<Doctor> list1=docRepo.saveAllAndFlush(list);
		return list1.size()+" number of records are inserted or saved ";
	}

}
