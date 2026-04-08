package com.amdocs.cargomanagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.cargomanagement.model.Driver;
import com.amdocs.cargomanagement.service.DriverService;

@Controller
public class DriverController {

	private final DriverService driService;

	public DriverController(DriverService driService) {
		this.driService = driService;
	}

	@RequestMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("dri", new Driver());
		return "driver";
	}

	@RequestMapping("/insert")
	public String handleDriForm(@ModelAttribute("dri") Driver dri, Model model) {
		boolean saveDriver = driService.saveDriver(dri);
		model.addAttribute("msg", saveDriver ? "Data inserted successfully" : "Data was not inserted");
		return "driver";
	}

	@RequestMapping("/viewAll")
	public String viewAllDrivers(Model model) {
		List<Driver> allDrivers = driService.getAllDrivers();
		model.addAttribute("drivers", allDrivers);
		return "view";
	}

	@RequestMapping("/deleteDri")
	public String deleteDriver(@RequestParam("did") int id) {
		driService.deleteDriver(id);
		return "redirect:/viewAll";
	}

	@RequestMapping("/editDri")
	public String editDriver(@RequestParam("did") int id, Model model) {
		Driver dri = driService.getDriverById(id);
		if (dri == null) {
			return "redirect:/viewAll";
		}
		model.addAttribute("dri", dri);
		return "editDriver";
	}

	@RequestMapping("/update")
	public String updateDriver(@ModelAttribute("dri") Driver dri) {
		driService.updateDriver(dri);
		return "redirect:/viewAll";
	}
}
