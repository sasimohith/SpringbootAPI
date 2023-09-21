package com.amdocs.springbootcasestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.springbootcasestudy.model.Driver;

@Repository
	public interface DriverRepository extends JpaRepository<Driver, Integer> {

		
	}

