package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bsim")
@Lazy
public class BSNLSim implements MobileSimCard {

	public BSNLSim() {
		System.out.println("BSNL Sim Object is created");
	}
	
	@Override
	public void simCard() {
		System.out.println("BSNL Sim:: Number is assigned");
	}

	@Override
	public void activateSim() {
		System.out.println("Your BSNL Sim is activated");
	}

}
