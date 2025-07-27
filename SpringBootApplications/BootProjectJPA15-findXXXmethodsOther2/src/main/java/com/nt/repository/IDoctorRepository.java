package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetween(List<String> specials,double start,double end);
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials,double start,double end);
}
