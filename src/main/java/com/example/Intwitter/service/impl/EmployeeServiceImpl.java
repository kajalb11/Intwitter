package com.example.Intwitter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intwitter.entity.Employee;
import com.example.Intwitter.repository.EmployeeRepository;
import com.example.Intwitter.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
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
