package com.example.Intwitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intwitter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{	
	public Employee findByIntweeterName(String intweeterName);
}
