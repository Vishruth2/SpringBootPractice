// CovidPatientImpl.java
package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.CovidPatient;

@Repository("covidDao")
public class CovidPatientImpl implements ICovidPatientDao {
	//create query
	private static final String GET_COVID_PATIENTS="SELECT FULL_NAME,AGE,GENDER,STATE,TEST_DATE,RESULT_DATE,TEST_RESULT, HOSPITALIZED FROM  COVID_PATIENT ORDER BY STATE ";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<CovidPatient> getCovidPatients() throws Exception {
		List<CovidPatient> list =null;
		
		try(Connection con=ds.getConnection();
			  PreparedStatement ps = con.prepareStatement(GET_COVID_PATIENTS);
			  ResultSet rs = ps.executeQuery())
		{
			list = new ArrayList<>();
			while(rs.next()) {
				CovidPatient cp = new CovidPatient();
				cp.setName(rs.getString(1));
				cp.setAge(rs.getInt(2));
				cp.setGender(rs.getString(3));
				cp.setState(rs.getString(4));
				cp.setTestDate(rs.getDate(5).toLocalDate());
				cp.setResultDate(rs.getDate(6).toLocalDate());
				cp.setTestResult(rs.getString(7));
				cp.setHospitalized(rs.getString(8));
				list.add(cp);
			}
			
		}catch (Exception e) {
			throw e;
		}
		return list;
	}

}
