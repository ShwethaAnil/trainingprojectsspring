package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Department;

public interface DepartmentDao {
	public void insertDepartment(Department e) ;
	public void updateDepartment(Department e) ;
	public void deleteDepartment(int deptid) ;
	public Department getDepartmentById(int id) ;
	public List<Department> getAll();
}
