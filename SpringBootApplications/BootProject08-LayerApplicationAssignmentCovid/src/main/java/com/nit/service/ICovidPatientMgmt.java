package com.nit.service;

import java.util.List;

import com.nit.model.CovidPatient;

public interface ICovidPatientMgmt {
	
	public List<CovidPatient> fetchCovidPatient() throws Exception;
}
