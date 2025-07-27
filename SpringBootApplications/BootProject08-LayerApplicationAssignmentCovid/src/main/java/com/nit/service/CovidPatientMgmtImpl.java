//CovidPatientMgmtImpl.java
package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.ICovidPatientDao;
import com.nit.model.CovidPatient;

@Service("covidService")
public class CovidPatientMgmtImpl implements ICovidPatientMgmt {

	@Autowired
	private ICovidPatientDao icpd;
	
	@Override
	public List<CovidPatient> fetchCovidPatient() throws Exception {
		List<CovidPatient> list = icpd.getCovidPatients();
		return list;
	}

}
