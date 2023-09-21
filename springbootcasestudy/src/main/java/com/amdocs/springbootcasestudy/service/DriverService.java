package com.amdocs.springbootcasestudy.service;

import java.util.List;

import com.amdocs.springbootcasestudy.model.Driver;

public interface DriverService {
	


		public boolean saveDriver(Driver dri);
		
		public List<Driver> getAllDrivers();
		
		public Driver getDriverId(int id);

		public boolean updateDriver(Driver st);

		public boolean deleteDriver(int id);
		




}
