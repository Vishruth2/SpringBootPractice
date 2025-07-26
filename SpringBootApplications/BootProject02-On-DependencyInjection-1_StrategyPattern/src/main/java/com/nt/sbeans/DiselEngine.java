package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dEngine")
@Lazy
public class DiselEngine implements IEngine {
	
	public DiselEngine() {
		System.out.println("DiselEngine Engine :: 0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("DiselEngine.start() :: Disel engine is started");

	}

	@Override
	public void stop() {
		System.out.println("DiselEngine.stop() :: Disel engine is stopped");
	}

}
