package com.bagas.spring.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagas.spring.rest.dao.EmployeeDAO;
import com.bagas.spring.rest.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

}
