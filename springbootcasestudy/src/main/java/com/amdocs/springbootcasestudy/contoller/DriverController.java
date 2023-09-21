package com.amdocs.springbootcasestudy.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.springbootcasestudy.model.Driver;
import com.amdocs.springbootcasestudy.service.impl.DriverServiceImpl;



@Controller
public class DriverController {

	@Autowired
	private DriverServiceImpl driService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		Driver dri=new Driver();
		model.addAttribute("dri", dri);
		
		return "driver";
	}
	
	@RequestMapping("/insert")
	public String handleDriForm(@ModelAttribute("dri")Driver dri,Model model)
	{
		
		//intract to service layer
		boolean saveDriver = driService.saveDriver(dri);
		
		String msg="";
		
		if(saveDriver)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "driver";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllDrivers(Model model)
	{
		//fetch the data from the databse ,can interact service layer
		List<Driver> allDrivers = driService.getAllDrivers();
		
		model.addAttribute("drivers", allDrivers);
		return "view";
	}
	
	@RequestMapping("/deleteDri")
	public String deleteDriver(@RequestParam("did")  int id)
	{
		boolean flag = driService.deleteDriver(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	
	@RequestMapping("/editDri")
	public String editDriver(@RequestParam("did") int id, Model model)
	{
		Driver dri = driService.getDriverId(id);
		
		model.addAttribute("dri", dri);
		return "editDriver";
	}
	
	@RequestMapping("/update")
	public String updateDriver(Driver dri)
	{
		boolean updateDriver = driService.updateDriver(dri);
		
		return "redirect:/viewAll";

	}
	
	

}
