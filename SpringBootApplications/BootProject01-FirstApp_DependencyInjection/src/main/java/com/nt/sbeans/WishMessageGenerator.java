//WishMessageGenerator.java
package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
//	private LocalDateTime dateTime;
	
//	@Autowired
//	public WishMessageGenerator(LocalDateTime dateTime) {
//		System.out.println("Wish Message Generator :: 0-param constructor");
//		this.dateTime=dateTime;
//	}

	@Autowired //Field Injection
	private LocalDateTime dateTime; //HAS - A property
	
	




	//business method
	public String generateMessage(String user) {
		//get current hour of the day
		int hour = dateTime.getHour();
		//generate the wish message
		if (hour<12) {
			return "Good Morning " +user;
		}
		else if (hour <16) {
			return "Good Afternoon "+ user ;
		}
		else if (hour<20) {
			return "Good Evening "+user; 
		}
		else {
			return "Good Night "+user;
		}
	}
	
	
}
