//CovidPatient.java //model class
package com.nit.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CovidPatient {
	
	public String name;
	public Integer age;
	public String gender;
	public String state;
	public LocalDate testDate;
	public LocalDate resultDate;
	public String testResult;
	public String hospitalized;
}
