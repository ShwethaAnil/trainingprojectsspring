package com.mphasis.training.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.DepartmentDao;
import com.mphasis.training.entities.Department;

@Service
public class DepartmentService implements com.mphasis.training.services.DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void insertDepartment(Department e) {
		departmentDao.insertDepartment(e);

	}

	public void updateDepartment(Department e) {
		// TODO Auto-generated method stub
		departmentDao.updateDepartment(e);
	}

	public void deleteDepartment(int e) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartment(e);
	}

	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentById(id);
	}

	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentDao.getAll();
	}

}
