package com.nt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class IDoctorManagementImpl implements IDoctorManagementService {
    @Autowired
    private IDoctorRepository docRepo;

    @Override
    public Iterable<Doctor> getAllDoctor(boolean ascOrder, String... properties) {
        // Create a Sort object based on the provided order and properties
        Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
        
        // Fetch and return the sorted list of doctors
        Iterable<Doctor> it = docRepo.findAll(sort);
        System.err.println(it);
        return it;
    }
}
