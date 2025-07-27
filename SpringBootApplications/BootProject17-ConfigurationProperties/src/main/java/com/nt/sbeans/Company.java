package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("company")
@ConfigurationProperties(prefix = "org.nit")
public class Company {
	private String name;
	private String address;
	private Long pinCode;
	private Long contact;

}
