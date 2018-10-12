package com.example.Intwitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intwitter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{	
	public Employee findByIntweeterName(String intweeterName);
	
	public List<Employee> findByIntweeterNameIn(String string);
	
}
