package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.cargomanagement.model.RouteEntity;
import com.amdocs.cargomanagement.service.RouteService;

/**
 * REST API for delivery routes. Example: POST http://localhost:8099/Route/insert/1
 */
@RestController
@RequestMapping("/Route")
public class RouteController {

	private final RouteService routeserv;

	public RouteController(RouteService routeserv) {
		this.routeserv = routeserv;
	}

	@PostMapping("/insert/{dno}")
	public RouteEntity saveRoute(@RequestBody RouteEntity route, @PathVariable Integer dno) {
		return routeserv.saveRoute(route, dno);
	}

	@GetMapping("/allRoutes")
	public List<RouteEntity> getAllRoutes() {
		return routeserv.getAllRoutes();
	}

	@GetMapping("/{routeid}")
	public RouteEntity getRouteById(@PathVariable int routeid) {
		return routeserv.getRouteById(routeid);
	}

	@PutMapping("/update/{routeid}")
	public RouteEntity updateRoute(@PathVariable int routeid, @RequestBody RouteEntity route) {
		return routeserv.updateRoute(routeid, route);
	}

	@DeleteMapping("/delete/{routeid}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRoute(@PathVariable int routeid) {
		routeserv.deleteRoute(routeid);
	}
}
