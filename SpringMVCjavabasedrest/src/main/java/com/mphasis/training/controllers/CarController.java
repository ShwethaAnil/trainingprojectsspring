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

@RestController
public class CarController {
	@Autowired
	CarService carService;
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	@RequestMapping(value="/cars",
	method=RequestMethod.GET,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Car> listCars() {
		return carService.getCars();
	}
	@RequestMapping(value="/car/add",method=RequestMethod.POST)
	public Car addCar(@RequestBody Car c) {
			this.carService.addCar(c);
		return c;
	}
	@DeleteMapping("/car/{carid}")
	public void removeCar(@PathVariable("carid")int carid) {
			this.carService.removeCar(carid);
	}
	@RequestMapping(value="/car/{carid}",method=RequestMethod.PUT)
	public void editCar(@PathVariable("carid")int carid,
	@RequestBody Car c) {
		carService.updateCar(c);
	}
	@RequestMapping(value="/car/{carid}",method=RequestMethod.GET)
	public Car getCar(@PathVariable("carid")int carid) {
		return carService.getCarById(carid);
	}
}