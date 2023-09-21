package com.amdocs.springbootcasestudy.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.springbootcasestudy.model.Driver;
import com.amdocs.springbootcasestudy.repo.DriverRepository;
import com.amdocs.springbootcasestudy.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository driRepo;

	@Override
	public boolean saveDriver(Driver dri) {
		// TODO Auto-generated method stub
		
		Driver driSave = driRepo.save(dri);
		boolean flag = false;
		
		if (driSave != null)
			flag = true;
		
		return flag;
	}

	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		List<Driver> driRecords = driRepo.findAll();
		return driRecords;
	}

	@Override
	public Driver getDriverId(int id) {
		// TODO Auto-generated method stub
		Optional<Driver> driId = driRepo.findById(id);
		Driver dri = driId.get();
		return dri;
	}

	@Override
	public boolean updateDriver(Driver st) {
		// TODO Auto-generated method stub
		
		
		return saveDriver(st);
	}

	@Override
	public boolean deleteDriver(int id) {
		// TODO Auto-generated method stub
		Driver dri = getDriverId(id);
		boolean flag = false;
		if(dri!=null)
		{
			driRepo.delete(dri);
			flag  = true;
		}
		return flag;
	}

}
