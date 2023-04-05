package com.bagas.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bagas.spring.rest.entity.Employee;
import com.bagas.spring.rest.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class MyRESTController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> showAllEmployees()
	{
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		Employee employee = employeeService.getEmployee(id);
		
		return employee;
	}
}