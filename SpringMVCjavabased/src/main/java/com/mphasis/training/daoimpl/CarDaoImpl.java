package com.mphasis.training.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.dao.CarDao;
import com.mphasis.training.entities.Car;

@Repository
@Transactional
public class CarDaoImpl implements CarDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertCar(Car car) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	session.persist(car);
	tr.commit();
	session.close();
	}

	public void updateCar(Car car) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(car);
		tr.commit();
		session.close();
	}

	public void deleteCar(int carid) {
		Session session=sessionFactory.openSession();
		Car car=(Car)session.get(Car.class, carid);
		Transaction tr=session.beginTransaction();
		session.delete(car);
		tr.commit();
		System.out.println("dao layer");
		session.close();
	}

	public Car retriveCarById(int carid) {
		Session session=sessionFactory.openSession();
		Car car=(Car)session.get(Car.class, carid);
		return car;
	}

	public List<Car> retriveCars() {
		Session session=sessionFactory.openSession();
		List<Car> cars=session.createCriteria(Car.class).list();
		return cars;
	}
}
