package com.example.Intweet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intweet.entity.Employee;
import com.example.Intweet.repository.EmployeeRepository;
import com.example.Intweet.service.EmployeeService;


@Service
public class EmployeeImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void saveEmployee(Employee employee) {
		empRepo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return empRepo.getOne(employeeId);
	}

}
