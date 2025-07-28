package com.nt.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
//	@Query("FROM Doctor WHERE income >= ?1 AND income <= ?2")
//	@Query("FROM Doctor doc WHERE income >= ?1 AND income <=?2")
//	@Query("FROM com.nt.entity.Doctor WHERE income >=?1 AND income <=?2")
//	@Query("SELECT doc FROM Doctor doc WHERE income >=?1 AND income <=?2")
//	@Query("SELECT doc FROM Doctor as doc WHERE income >=?1 AND income <=?2")
//	@Query("SELECT doc FROM Doctor doc WHERE income >=:startRange AND income <=:endRange")
//	@Query("FROM Doctor WHERE income >=?1 AND income <=?3") --> error  //Gap between '?1' and '?3' in ordinal parameter labels [1,3] (ordinal parameters must be labelled sequentially)
//	@Query("SELECT doc FROM Doctor as doc WHERE income >=?0 AND income <=?1")  // error  Reason: Index position must be greater zero
//	@Query("SELECT doc FROM Doctor as doc WHERE income >=?2 AND income <=?1") //valid but senseless
//	@Query("FROM Doctor WHERE income >=:startRange AND income <= ?2")  //error ordinal parameter starts from 1
//	@Query("FROM Doctor WHERE income >=:startRange AND income <= ?1") //I'm getting an output
	@Query("FROM Doctor WHERE income >=?1 AND income <= :endRange") // I'm getting an output 
	public List<Doctor> searchDoctorByIncomeRange(double startRange,double endRange);
	
//	@Query("FROM ?1 WHERE income >= ?2 AND income <= ?3")  //
//    public List<Doctor> searchViaIncome(String clazz,double startRange,double endRange);



	
	/**
	 * If HQL/JPQL Query's named parameters (:<name>) names and custom method
	 * parameter names are matching then no need of placing @Param annotations in 
	 * before java methods parameters.. otherwise placing them is mandatory.
	 * */
	
//	@Query("FROM Doctor WHERE income >= :start AND income <=:end")
//	public List<Doctor> searchDoctorByIncomeRange(@Param("start") double startRange, @Param("end") double endRange);

}
