package com.example.Intweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intweet.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	public Employee findByIntweeterName(String intweeterName);
	
	public List<Employee> findByIntweeterNameIn(List<String> userName);
	
	
}
