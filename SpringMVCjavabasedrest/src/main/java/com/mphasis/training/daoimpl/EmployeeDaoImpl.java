package com.mphasis.training.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.dao.EmployeeDao;
import com.mphasis.training.entities.Car;
import com.mphasis.training.entities.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e);
		tr.commit();
		session.close();
	}

	public void updateEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(e);
		tr.commit();
		session.close();

	}

	public void deleteEmployee(int id) {
		Session session=sessionFactory.openSession();
		Employee employee=(Employee)session.get(Employee.class, id);
		Transaction tr=session.beginTransaction();
		session.delete(employee);
		tr.commit();
		session.close();

	}

	public Employee getEmployeeById(int id) {
		Session session=sessionFactory.openSession();
		Employee employee=(Employee)session.get(Employee.class, id);
		Transaction tr=session.beginTransaction();
		
		tr.commit();
		session.close();
		return employee;
	}

	public List<Employee> getAll() {
		Session session=sessionFactory.openSession();
		List<Employee> employees=session.createCriteria(Employee.class).list();
		return employees;
	}

}
