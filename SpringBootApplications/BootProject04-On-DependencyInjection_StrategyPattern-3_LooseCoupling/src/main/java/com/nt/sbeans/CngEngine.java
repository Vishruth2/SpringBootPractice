package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("cEngine")
@Lazy
public class CngEngine implements IEngine {
	
	public CngEngine() {
		System.out.println("CngEngine Engine :: 0-param constructor");
	}
	
	@Override
	public void start() {
		System.out.println("CngEngine.start() :: CNG engine is started");

	}

	@Override
	public void stop() {
		System.out.println("CngEngine.stop() :: CNG engine is stopped");

	}

}
