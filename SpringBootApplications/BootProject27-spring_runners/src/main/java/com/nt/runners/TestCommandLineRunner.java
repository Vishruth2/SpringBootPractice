package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TestCommandLineRunner.run():: Run method");
		
		System.err.println("Runner to Test command Line runner ::"+Arrays.toString(args));

	}

	public TestCommandLineRunner() {
		System.out.println("TestCommandLineRunner.TestCommandLineRunner(:: ):: Constructor");
		
		System.out.println("==============================================");
		System.out.println("==============================================");
		System.out.println("==============================================");
	}

}
