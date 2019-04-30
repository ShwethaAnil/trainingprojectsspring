package com.mphasis.training.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.EmployeeDao;
import com.mphasis.training.entities.Employee;

@Service
public class EmployeeService implements com.mphasis.training.services.EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(e);
	}

	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(e);
	}

	public void deleteEmployee(int e) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(e);
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}

}
