package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneMgmtService;
@Component
public class VersioningAndTimeStampingRunners implements CommandLineRunner {
	
	@Autowired
	private ICallerTuneMgmtService itune;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		try {
			CallerTuneInfo info=new CallerTuneInfo("Lose My Mind","F1");
			String result=itune.saveCallerTuneInfo(info);
			System.err.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
     */
		/*
		try {
			System.err.println(itune.updateTuneInfoById(1, "Eye For An Eye", "John wick 4"));
			System.err.println(itune.showCallerTuneDetailsById(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
			System.err.println(itune.updateTuneInfoById(1, "Can you hear the music", "Oppenheimer"));
			System.err.println(itune.showCallerTuneDetailsById(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
