package com.mphasis.training.services;

import java.util.List;

import com.mphasis.training.entities.Car;

public interface CarService {
	public void addCar(Car car);
	public void updateCar(Car car);
	public void removeCar(int carid);
	public Car getCarById(int carid);
	public List<Car> getCars();
}
