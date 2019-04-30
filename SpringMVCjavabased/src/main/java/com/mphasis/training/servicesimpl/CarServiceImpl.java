package com.mphasis.training.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.CarDao;
import com.mphasis.training.entities.Car;
import com.mphasis.training.services.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;
	
	public void addCar(Car car) {
		carDao.insertCar(car);
		
	}

	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		carDao.updateCar(car);
	}

	public void removeCar(int carid) {
		// TODO Auto-generated method stub
		System.out.println("service car id"+carid);
		carDao.deleteCar(carid);
	}

	public Car getCarById(int carid) {
		// TODO Auto-generated method stub
		return carDao.retriveCarById(carid);
	}

	public List<Car> getCars() {
		// TODO Auto-generated method stub
		return carDao.retriveCars();
	}

}
