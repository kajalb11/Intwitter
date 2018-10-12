package com.example.Intwitter.service;

import com.example.Intwitter.entity.Employee;

public interface EmployeeService 
{	
	
	public void saveEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);

}
