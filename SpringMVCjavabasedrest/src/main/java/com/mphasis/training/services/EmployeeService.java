package com.mphasis.training.services;

import java.util.List;

import com.mphasis.training.entities.Employee;

public interface EmployeeService {
	public void insertEmployee(Employee e) ;
	public void updateEmployee(Employee e) ;
	public void deleteEmployee(int  e) ;
	public Employee getEmployeeById(int id) ;
	public List<Employee> getAll();
}
