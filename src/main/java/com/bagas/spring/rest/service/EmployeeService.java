package com.bagas.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bagas.spring.rest.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);
	
}
