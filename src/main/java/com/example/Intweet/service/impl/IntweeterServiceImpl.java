package com.example.Intweet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intweet.entity.Employee;
import com.example.Intweet.entity.InTweet;
import com.example.Intweet.model.TweetRequest;
import com.example.Intweet.repository.EmployeeRepository;
import com.example.Intweet.repository.IntweetRepository;
import com.example.Intweet.service.IntweerService;

@Service
public class IntweeterServiceImpl implements IntweerService {

	@Autowired
	IntweetRepository intweetRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	public void saveTweet(TweetRequest tweetRequest) {
		Employee emp = empRepo.findByIntweeterName(tweetRequest.getUserName());
		intweetRepo.save(InTweet.builder().employeeId(emp.getEmployeeId()).emailId(emp.getEmailId()).intweetMessage(tweetRequest.getTweetMessage()).build());
	}

}
