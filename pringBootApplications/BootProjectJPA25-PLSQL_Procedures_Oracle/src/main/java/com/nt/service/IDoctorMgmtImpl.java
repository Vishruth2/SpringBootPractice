package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

	/*
	 * CREATE OR REPLACE PROCEDURE P_GET_DOCTORS_BY_INCOME_RANGE 
	(
	  STARTINCOME IN FLOAT 
	, ENDINCOME IN FLOAT 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  OPEN DETAILS FOR
	        SELECT * FROM JPA_DOCTOR_TAB WHERE INCOME>=STARTINCOME AND INCOME<=ENDINCOME; 
	END P_GET_DOCTORS_BY_INCOME_RANGE;
 * */


@Service
public class IDoctorMgmtImpl implements IDoctorMgmt {

	@Autowired
	private EntityManager manager;
	
	@Override
//	@Transactional
	public List<Doctor> showDoctorByIncomeRange(double start, double end) {
		//create StoredProcedureQuery object pointing PL/SQL procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE",Doctor.class);
		//register both IN,OUT,INOUT Parameter by specifying their mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, void.class, ParameterMode.REF_CURSOR);
//		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR); we can write this also but preferred one above one
		
		
		//set values to IN params
		query.setParameter(1, start);
		query.setParameter(2, end);
		
//		query.execute();
		
		/*
		 * if you use query.execute() then we have to write @Transactional
		 * if you don't use query.execute() then no need to write @Transactional
		 * */
		
		//call pl/sql procedure
		List<Doctor> doctors=query.getResultList();
		return doctors;
	}
	
}
