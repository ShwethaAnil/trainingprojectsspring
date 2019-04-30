package com.mphasis.training.dao;

import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.entities.Employee;

public interface EmployeeDao {
	
	public void insertEmployee(Employee e) ;
	public void updateEmployee(Employee e) ;
	public void deleteEmployee(int empid) ;
	public Employee getEmployeeById(int id) ;
	public List<Employee> getAll();
}
