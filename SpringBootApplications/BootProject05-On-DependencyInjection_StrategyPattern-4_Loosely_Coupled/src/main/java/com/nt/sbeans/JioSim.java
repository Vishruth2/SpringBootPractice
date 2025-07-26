package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("jsim")
@Lazy
public class JioSim implements MobileSimCard {
	
	public JioSim() {
		System.out.println("Jio Sim Object is created");
	}

	@Override
	public void simCard() {
		System.out.println("Jio Sim:: Number is assigned");
	}

	@Override
	public void activateSim() {
		System.out.println("Your Jio Sim is activated");
	}

}
