package com.nt.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationRunner implements ApplicationRunner {

	
	

	public TestApplicationRunner() {
		System.err.println("Constructor of TestApplicationRunner()  ");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println("Non option args values :: "+args.getNonOptionArgs());
		
		System.err.println("Option arg names and values :: ");
		for (String name : args.getOptionNames()) {
			System.err.println(name +"==========>"+args.getOptionValues(name));
		}
		

	}

}
