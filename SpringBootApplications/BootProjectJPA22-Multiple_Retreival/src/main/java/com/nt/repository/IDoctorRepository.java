package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	

	//--------------------------Entity Query giving single record ---------------------------------
	@Query("FROM Doctor WHERE docName=:name")
	public Optional<Doctor> showDoctorInfoByName(String name);
	
	
	//--------------------------Entity Query giving Multiple Columns ---------------------------------
	@Query("SELECT docId,docName,specialization FROM Doctor WHERE specialization=:specials")
	public List<Object[]> showDoctorInforBySpecialization(String specials);
	
	
	//--------------------------Entity Query giving Single Columns ---------------------------------
	@Query("SELECT docName FROM Doctor WHERE specialization=:specials")
	public List<String> showDoctorNameBySpecialization(String specials);
	
	

	
	/**
	 * If HQL/JPQL Query's named parameters (:<name>) names and custom method
	 * parameter names are matching then no need of placing @Param annotations in 
	 * before java methods parameters.. otherwise placing them is mandatory.
	 * */
	

}
