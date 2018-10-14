package com.example.Intwitter.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(FollowingServiceImpl.class);
	
	@Autowired
	IntweetRepository intweetRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override 
	public void postIntweet(IntweetRequest intweetRequest) 
	{
		String loggedInUserName = intweetRequest.getIntweeterName();
		logger.info("current logged in user name {}", loggedInUserName);
		
		String intweetMessage = intweetRequest.getIntweetMessage().trim();
		logger.info("intweet message {}", intweetMessage);
		
		int intweetMessageLength = intweetMessage.length();
		logger.info("intweet message length {}", intweetMessageLength);
		
		Employee emp = empRepo.findByIntweeterName(loggedInUserName);
		Long loggedInUsedEmpId = emp.getEmployeeId();
		logger.info("current logged in user emp Id {}", loggedInUsedEmpId);
		
		intweetRepo.save(Intweet.builder().employeeId(loggedInUsedEmpId).intweetMessage(intweetMessage).build());
	}

}
