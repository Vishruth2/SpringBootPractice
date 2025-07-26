package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mobile")

public class Mobile {
	
	public Mobile() {
		System.out.println("Mobile Object is created");
	}

	//HAS-A property
	@Autowired
	@Qualifier("simcard")
	private MobileSimCard mobileSimCard;
	
	//b method
	public void simDetails() {
		System.out.println("Information About Sim");
		mobileSimCard.simCard();
		System.out.println("About Activation");
		mobileSimCard.activateSim();
	}
}
