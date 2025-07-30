package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO JPA_DOCTOR_TAB (DOC_ID,DOC_NAME,INCOME,SPECIALIZATION) VALUES(JPA_DOCTOR_TAB_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery = true)
	public int registerDoctor(String name,String special,double income);
	
	@Query(value = "SELECT SYSDATE FROM DUAL" ,nativeQuery = true)
	public String showSystemDate();
	
	@Transactional
	@Modifying
	@Query(value = "CREATE TABLE TEMPO(col1 number(5))" , nativeQuery = true)
	public int createTempoTable();
}
