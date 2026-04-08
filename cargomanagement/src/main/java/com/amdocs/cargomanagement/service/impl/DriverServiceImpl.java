package com.amdocs.cargomanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amdocs.cargomanagement.model.Driver;
import com.amdocs.cargomanagement.repo.DriverRepository;
import com.amdocs.cargomanagement.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	private final DriverRepository driRepo;

	public DriverServiceImpl(DriverRepository driRepo) {
		this.driRepo = driRepo;
	}

	@Override
	public boolean saveDriver(Driver dri) {
		Driver driSave = driRepo.save(dri);
		return driSave != null;
	}

	@Override
	public List<Driver> getAllDrivers() {
		return driRepo.findAll();
	}

	@Override
	public Driver getDriverById(int id) {
		return driRepo.findById(id).orElse(null);
	}

	@Override
	public boolean updateDriver(Driver st) {
		return saveDriver(st);
	}

	@Override
	public boolean deleteDriver(int id) {
		if (!driRepo.existsById(id)) {
			return false;
		}
		driRepo.deleteById(id);
		return true;
	}
}
