package com.mphasis.training.services;

import java.util.List;

import com.mphasis.training.entities.Department;

public interface DepartmentService {
	public void insertDepartment(Department e) ;
	public void updateDepartment(Department e) ;
	public void deleteDepartment(int e) ;
	public Department getDepartmentById(int id) ;
	public List<Department> getAll();
}
