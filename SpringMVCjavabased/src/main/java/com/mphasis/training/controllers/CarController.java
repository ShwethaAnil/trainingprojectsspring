package com.mphasis.training.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.entities.Car;
import com.mphasis.training.services.CarService;

@Controller
public class CarController {
	@Autowired
	CarService carService;
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	@RequestMapping(value="/cars",
	method=RequestMethod.GET)
	public String listCars(Model model) {
		model.addAttribute("car",new Car());
		model.addAttribute("listcar", this.carService.getCars());
		return "cars";
	}
	@RequestMapping(value="/car/add",method=RequestMethod.POST)
	public String addCar(@ModelAttribute Car c) {
			if(c.getCarid()==0)
		this.carService.addCar(c);
			else
				this.carService.updateCar(c);
		return "redirect:/cars";
	}
	@RequestMapping("/remove/{carid}")
	public String removeCar(@PathVariable("carid")int carid) {
			this.carService.removeCar(carid);
			return "redirect:/cars";
	}
	
	@RequestMapping(value="/edit/{carid}")
	public String editCar(@PathVariable("carid")int carid,Model model) {
		model.addAttribute("car",carService.getCarById(carid));
		model.addAttribute("listcar", this.carService.getCars());
		return "car"; 
	}
}