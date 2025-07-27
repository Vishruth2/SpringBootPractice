//Hotel .java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

//@Getter
@Component("hotel")
public class Hotel {
	
	@Value("1234") //Direct value injection
	private Integer hotelId;
	
	@Value("${hotel.name}")
	private String hotelName;
	
	@Value("${hotel.address}")
	private String hotelAddress;
	
	@Value("${hotel.contactno}")
	private String mobileNo;
	
	@Value("${customer.name}")
	private String custName;
	
	@Value("#{menup.idlyPrice+menup.dosaPrice}")//SPEL for arithmetic expression
	private Float billAmount;
	
	@Value("${os.name}")  //os.name is fixed system property key
	private String osName;
	
	@Value("${user.name}") //user.name is fixed system property
	private String windowUser;
	
	@Value("${Path}")//Path is fixed env variable name
	private String pathData;

	//toString() method (alt+shift+s,s)
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", mobileNo=" + mobileNo + ", custName=" + custName + ", billAmount=" + billAmount + ", osName="
				+ osName + ", windowUser=" + windowUser + ", pathData=" + pathData + "]";
	}
	

}//end
