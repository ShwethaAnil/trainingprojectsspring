package com.mphasis.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.entities.Department;
import com.mphasis.training.services.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@RequestMapping(value="/department/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void insertDepartment(@RequestBody Department e) {
		departmentService.insertDepartment(e);
	}
	@RequestMapping(value="/department/{deptid}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateDepartment(@PathVariable("deptid")int deptid,@RequestBody Department e) {
		departmentService.updateDepartment(e);
	}
	@RequestMapping(value="/department/{deptid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteDepartment(@PathVariable("deptid")int e) {
		departmentService.deleteDepartment(e);
	}
	@RequestMapping(value="/department/{deptid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Department getDepartmentById(@PathVariable("deptid")int id) {
		return departmentService.getDepartmentById(id);
	}
	@RequestMapping(value="/departments",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getAll(){
		return departmentService.getAll();
	}
}
