//CovidPatientController.java
package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.CovidPatient;
import com.nit.service.ICovidPatientMgmt;


@Controller("covidController")
public class CovidPatientController {
	
	@Autowired
	private ICovidPatientMgmt icpm;
	
	public List<CovidPatient> getCovidPatientDetails() throws Exception{
		List<CovidPatient> list = icpm.fetchCovidPatient();
		return list;
	}
	
}
