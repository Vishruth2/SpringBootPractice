package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.MarriageSeeker;

public interface IMariageSeekerRepo extends JpaRepository<MarriageSeeker, Long> {

}
