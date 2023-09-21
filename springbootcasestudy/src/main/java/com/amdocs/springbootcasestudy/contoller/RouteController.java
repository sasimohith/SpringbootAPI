package com.amdocs.springbootcasestudy.contoller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.springbootcasestudy.service.RouteService;
import com.amdocs.springbootcasestudy.exception.DriverNotFoundException;
import com.amdocs.springbootcasestudy.model.RouteEntity;
import com.amdocs.springbootcasestudy.service.DriverService;

@RestController
@RequestMapping("/Route")
public class RouteController {
	private RouteService routeserv;
	private DriverService driverserv;
	
	@Autowired
	public RouteController(RouteService routeserv, DriverService driverserv) {
		super();
		this.routeserv = routeserv;
		this.driverserv = driverserv;
	}
	//Basic URI for API Testing
	
	//http://localhost:8085/books
	
	//insert into book_entity(book_name, pub_date)values(?,?);
	//http://localhost:8085/books/insert
	@PostMapping("/insert/{dno}")
	public RouteEntity saveRoute(@RequestBody RouteEntity route,@PathVariable Integer dno) 
	{
		try {
		return routeserv.saveRoute(route,dno);
	}
	catch(DriverNotFoundException e)
		{
		System.out.println(e);
		
		}
		return null;
	}
	//select *from book_entity
	//http://localhost:8085/books/allbooks

	@GetMapping("/allRoutes")
	public List<RouteEntity> getAllRoutes()
	{
		return routeserv.getAllRoutes();
		
	}
	
	//select *from book_entity where isbnno=?
	//http://localhost:8085/books/1
	
	@GetMapping("/{routeid}")
	public RouteEntity getRouteById(@PathVariable int routeid)
	{
		return routeserv.getRouteById(routeid);
	}
	
	//http://localhost:8085/books/update/1
	@PutMapping("/update/{routeid}")
	public RouteEntity updateRoute(@PathVariable int routeid,@RequestBody RouteEntity route)
	{
		try {
		return routeserv.updateRoute(routeid, route);
	}
		catch(DriverNotFoundException e) 
		{
		System.out.println(e);	
		}
		return null;
	}
	
	@DeleteMapping("/delete/{routeid}")
	public void deleteRoute(@PathVariable int routeid)
	{
		routeserv.deleteRoute(routeid);
	}
	
}
