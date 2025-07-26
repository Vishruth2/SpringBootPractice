package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pEngine")
@Lazy
public class PetrolEngine implements IEngine {

		
	
	public PetrolEngine() {
		System.out.println("Petrol Engine :: 0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("PetrolEngine.start() :: Petrol Engine is started");
	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop() :: Petrol Engine is stopped");

	}

}
