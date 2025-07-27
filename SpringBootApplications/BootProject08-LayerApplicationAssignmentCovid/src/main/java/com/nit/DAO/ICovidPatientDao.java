package com.nit.DAO;

import java.util.List;

import com.nit.model.CovidPatient;

public interface ICovidPatientDao {
	public List<CovidPatient> getCovidPatients() throws Exception;

}
