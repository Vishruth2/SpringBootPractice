package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMariageSeekerRepo;

@Service
public class IMatrimonyServiceImpl implements IMatrimonyServiceMgmt {

	@Autowired
	private IMariageSeekerRepo mrepo;
 	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage seeker details are saved with an id value : "+mrepo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {
		return mrepo.findById(id);
	}

	@Override
	public List<MarriageSeeker> showAll() {
	    List<MarriageSeeker> list = mrepo.findAll();
	    return list;
	}

}
