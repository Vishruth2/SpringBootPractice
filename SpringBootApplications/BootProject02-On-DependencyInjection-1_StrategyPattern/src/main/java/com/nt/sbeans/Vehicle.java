package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	public Vehicle() {
		System.out.println("Vehicle.Vehicle():: 0-param constructor");
	}
	
	//HAS-A property for Field Injection
	@Autowired
	@Qualifier("dEngine")
	private IEngine engine;
	
	public void journey(String startPlace,String endPlace) {
		System.out.println("Vehicle.journey()");
		//start the engine to start the journey
		engine.start();
		System.out.println("Vehicle journey started from "+startPlace);
		
		System.out.println("Vehicle.journey() is going on..");
		
		engine.stop();
		
		//stop the engine when journey is stopped
		System.out.println("Vehicle journey is ended at "+endPlace);
		
		
	}
	

}
