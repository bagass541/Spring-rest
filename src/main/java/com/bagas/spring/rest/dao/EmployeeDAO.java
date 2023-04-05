package com.bagas.spring.rest.dao;

import java.util.List;

import com.bagas.spring.rest.entity.Employee;



public interface EmployeeDAO {
	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
}
