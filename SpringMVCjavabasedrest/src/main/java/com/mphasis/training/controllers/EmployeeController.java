package com.mphasis.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.entities.Employee;
import com.mphasis.training.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value="/employee/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void insertEmployee(@RequestBody Employee e) {
		employeeService.insertEmployee(e);
	}
	@RequestMapping(value="/employee/{empid}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@PathVariable("empid")int empid,@RequestBody Employee e) {
		employeeService.updateEmployee(e);
	}
	@RequestMapping(value="/employee/{empid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteEmployee(@PathVariable("empid")int  e) {
		employeeService.deleteEmployee(e);
	}
	
	@RequestMapping(value="/employee/{empid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("empid")int id) {
		return employeeService.getEmployeeById(id);
	}
	@RequestMapping(value="/employees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	

}
