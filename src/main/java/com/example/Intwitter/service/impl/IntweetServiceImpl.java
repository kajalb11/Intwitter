package com.example.Intwitter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intwitter.entity.Employee;
import com.example.Intwitter.entity.Intweet;
import com.example.Intwitter.model.IntweetRequest;
import com.example.Intwitter.repository.EmployeeRepository;
import com.example.Intwitter.repository.IntweetRepository;
import com.example.Intwitter.service.IntweetService;

@Service
public class IntweetServiceImpl implements IntweetService 
{

	@Autowired
	IntweetRepository intweetRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	public void saveIntweet(IntweetRequest intweetRequest) 
	{
		Employee emp = empRepo.findByIntweeterName(intweetRequest.getIntweeterName());
		intweetRepo.save(Intweet.builder().employeeId(emp.getEmployeeId()).intweetMessage(intweetRequest.getIntweetMessage()).build());
	}

}
