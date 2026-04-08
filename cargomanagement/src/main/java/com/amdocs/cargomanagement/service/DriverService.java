package com.amdocs.cargomanagement.service;

import java.util.List;

import com.amdocs.cargomanagement.model.Driver;

public interface DriverService {

	boolean saveDriver(Driver dri);

	List<Driver> getAllDrivers();

	Driver getDriverById(int id);

	boolean updateDriver(Driver st);

	boolean deleteDriver(int id);
}
