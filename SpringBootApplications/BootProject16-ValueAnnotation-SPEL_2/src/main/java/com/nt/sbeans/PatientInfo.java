package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("paInfo")
@Data
public class PatientInfo {
	
	@Value("10001")
	private Integer pid;
	
	@Value("${pi.name}")
	private String pname;
	
	@Value("${pi.mobileNo}")
	private Long mobileNo;
	
	@Value("${pi.address}")
	private String paddress;
	
	@Value("#{dcc.xrayPrice+dcc.ctscanPrice+dcc.ecgPrice}")
	private Double billAmount;
	
	@Value("#{dcc.ecgPrice<=0}") //spel
	private Boolean ecgFree;
	
	
	/**
	@Value("#{paInfo.mobileNo+paInfo.pname}")
	private String xxxvis;
	
	It give's error
	***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

┌──->──┐
|  paInfo (field private java.lang.String com.nt.sbeans.PatientInfo.xxxvis)
└──<-──┘


Action:

Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.


	*/

}
