package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("isim")
@Lazy
public class IdeaSim implements MobileSimCard {
	
	public IdeaSim() {
		System.out.println("Idea Sim Object is created");
	}
	
	@Override
	public void simCard() {
		System.out.println("Idea Sim:: Number is assigned");
	}

	@Override
	public void activateSim() {
		System.out.println("Your Idea Sim is activated");
	}

}
