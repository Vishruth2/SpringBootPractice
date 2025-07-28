package com.nt.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	

	//Multiple Columns retrieval
	@Query("SELECT docId,docName,income FROM Doctor WHERE income BETWEEN :startRange AND :endRange")
	public List<Object[]> searchDoctorByIncome(double startRange,double endRange);


	
	/**
	 * If HQL/JPQL Query's named parameters (:<name>) names and custom method
	 * parameter names are matching then no need of placing @Param annotations in 
	 * before java methods parameters.. otherwise placing them is mandatory.
	 * */
	

}
