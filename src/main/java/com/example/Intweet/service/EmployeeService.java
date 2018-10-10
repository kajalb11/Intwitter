package com.example.Intweet.service;

import com.example.Intweet.entity.Employee;

public interface EmployeeService {

	
	public void saveEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
}
