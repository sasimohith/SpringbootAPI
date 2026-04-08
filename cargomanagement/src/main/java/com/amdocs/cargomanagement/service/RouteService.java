package com.amdocs.cargomanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amdocs.cargomanagement.exception.ResourceNotFoundException;
import com.amdocs.cargomanagement.model.Driver;
import com.amdocs.cargomanagement.model.RouteEntity;
import com.amdocs.cargomanagement.repo.DriverRepository;
import com.amdocs.cargomanagement.repo.RouteRepository;

@Service
public class RouteService {

	private final RouteRepository routerepo;
	private final DriverRepository driverrepo;

	public RouteService(RouteRepository routerepo, DriverRepository driverrepo) {
		this.routerepo = routerepo;
		this.driverrepo = driverrepo;
	}

	public RouteEntity saveRoute(RouteEntity route, Integer dno) {
		Driver driver1 = driverrepo.findById(dno)
				.orElseThrow(() -> new ResourceNotFoundException("Driver not found: " + dno));
		route.setDrivers(driver1);
		return routerepo.save(route);
	}

	public List<RouteEntity> getAllRoutes() {
		return routerepo.findAll();
	}

	public RouteEntity getRouteById(int routeid) {
		return routerepo.findById(routeid)
				.orElseThrow(() -> new ResourceNotFoundException("Route not found: " + routeid));
	}

	public RouteEntity updateRoute(int routeid, RouteEntity route) {
		RouteEntity existingroute = routerepo.findById(routeid)
				.orElseThrow(() -> new ResourceNotFoundException("Route not found: " + routeid));
		existingroute.setBoardingPoint(route.getBoardingPoint());
		existingroute.setDeparturePoint(route.getDeparturePoint());
		existingroute.setTravelstartDate(route.getTravelstartDate());
		existingroute.setTravelendDate(route.getTravelendDate());
		return routerepo.save(existingroute);
	}

	public void deleteRoute(int routeid) {
		if (!routerepo.existsById(routeid)) {
			throw new ResourceNotFoundException("Route not found: " + routeid);
		}
		routerepo.deleteById(routeid);
	}
}
