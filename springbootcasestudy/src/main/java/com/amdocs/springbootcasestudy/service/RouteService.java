package com.amdocs.springbootcasestudy.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.springbootcasestudy.repo.DriverRepository;
import com.amdocs.springbootcasestudy.repo.RouteRepository;
import com.amdocs.springbootcasestudy.model.RouteEntity;
import com.amdocs.springbootcasestudy.exception.DriverNotFoundException;
import com.amdocs.springbootcasestudy.model.Driver;

@Service
public class RouteService {
	

private RouteRepository routerepo;
private DriverRepository driverrepo;

	@Autowired
	public RouteService(RouteRepository routerepo,DriverRepository driverrepo) {
		super();
		this.routerepo = routerepo;
		this.driverrepo = driverrepo;
	}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public RouteEntity saveRoute(RouteEntity route,Integer dno) throws DriverNotFoundException
	{
		Driver driver1 = driverrepo.findById(dno).orElse(null);
		if(driver1!=null)
		{
			route.setDrivers(driver1);
			return routerepo.save(route);
		}
		else {
		throw new DriverNotFoundException("Driver does not Exist");
	}
	
	}
	public List<RouteEntity> getAllRoutes()
	{
		return routerepo.findAll();
	}
	
	public 	RouteEntity getRouteById(int routeid)
	{
		return routerepo.findById(routeid).orElse(null);
	}

	public RouteEntity updateRoute(int routeid, RouteEntity route)throws DriverNotFoundException
	{
		RouteEntity existingroute=routerepo.findById(routeid).orElse(null);
		
		if(existingroute!=null)
		{
			existingroute.setBoarding_point(route.getBoarding_point());
			existingroute.setDeparture_point(route.getDeparture_point());
			existingroute.setTravelstartDate(route.getTravelstartDate());
			existingroute.setTravelendDate(route.getTravelendDate());
		return routerepo.save(existingroute);
		}
		throw new DriverNotFoundException("Driver does not Exist");
	}
	public void deleteRoute(int routeid){
		routerepo.deleteById(routeid);
	}
}