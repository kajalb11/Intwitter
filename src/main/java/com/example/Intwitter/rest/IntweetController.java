package com.example.Intwitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.model.IntweetRequest;
import com.example.Intwitter.repository.IntweetRepository;
import com.example.Intwitter.service.IntweetService;

@RestController
public class IntweetController 
{

Logger logger = LoggerFactory.getLogger(FollowingController.class);
	
	@Autowired
	IntweetService intweetService;
	
	@Autowired
	IntweetRepository intweetRepo;
	
	@RequestMapping(value="/intweet")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postIntweet(@RequestBody IntweetRequest intweetRequest)
	{
		logger.info("inside post intweet ");
		intweetService.postIntweet(intweetRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getAllIntweets")
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllIntweets()
	{
		logger.info("inside getAllIntweets ");
		return ResponseEntity.ok(intweetRepo.findAll());
	}
}
