package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Car;

public interface CarDao {
	public void insertCar(Car car);
	public void updateCar(Car car);
	public void deleteCar(int carid);
	public Car retriveCarById(int carid);
	public List<Car> retriveCars();
}
