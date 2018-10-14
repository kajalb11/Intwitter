package com.example.Intwitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.repository.IntweetRepository;
import com.example.Intwitter.service.FeedService;

@RestController
//@RequestMapping(value = "/feed")
public class FeedController 
{
	Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	@Autowired
	FeedService feedService;
	
	@Autowired
	IntweetRepository intweetRepo;
	
	@GetMapping(value="/feed/{currentIntweeterName}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFeed(@PathVariable String currentIntweeterName)
	{
		logger.info("Inside FeedController : getFeed for user {}", currentIntweeterName);
		return new ResponseEntity<>(feedService.getFeed(currentIntweeterName),HttpStatus.OK);	
	}
}
