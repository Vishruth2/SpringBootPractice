package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneRepository;

@Service
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService {

	@Autowired
	private ICallerTuneRepository callerTuneRepo;
	
	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		CallerTuneInfo callerTuneInfo=callerTuneRepo.save(info);
		Integer id = callerTuneInfo.getTuneId();
		return "Caller Tune is saved with the id value :"+id;
	}

	@Override
	public String updateTuneInfoById(Integer id, String tuneName, String movieName) {
		Optional<CallerTuneInfo> info=callerTuneRepo.findById(id);
		if (info.isPresent()) {
			CallerTuneInfo callerTuneInfo=info.get();
			callerTuneInfo.setTuneName(tuneName);
			callerTuneInfo.setMovieName(movieName);
			CallerTuneInfo tune=callerTuneRepo.save(callerTuneInfo);
			return "Object is updated for "+tune.getUpdatedCount()+" times..... lastly modified on :"
												+tune.getLastlyUpdatedOn()+" ...created on :: "+tune.getServiceOptedOn();
		} else {
			return "Caller Tune Service is not found";
		}
		
	}

	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		return callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Caller tune not found"));
	}

}
