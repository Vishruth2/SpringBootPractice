package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("aSim")
@Lazy
public class AirtelSim implements MobileSimCard {
	
	public AirtelSim() {
		System.out.println("Airtel Sim Object is created");
	}

	@Override
	public void simCard() {
		System.out.println("AirtelSim:: Number is assigned");

	}

	@Override
	public void activateSim() {
		System.out.println("Your AirtelSim is activated");

	}

}
