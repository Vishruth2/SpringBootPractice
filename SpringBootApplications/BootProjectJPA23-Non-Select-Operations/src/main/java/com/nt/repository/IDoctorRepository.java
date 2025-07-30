package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	@Modifying
	@Transactional
	@Query("UPDATE Doctor d SET d.income=d.income+(d.income* :percentage/100.0) WHERE specialization= :sp")
	public int hikeDoctorsIncomeBySpecialization(String sp,double percentage);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Doctor WHERE income>:start AND income <= :end")
	public int removeDoctorByIncomeRange(double start ,double end);
	
	
}
