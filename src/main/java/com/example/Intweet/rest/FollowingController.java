package com.example.Intweet.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intweet.model.FollowingRequest;
import com.example.Intweet.repository.FollowingRepository;
import com.example.Intweet.service.FollowingService;

@RestController
@RequestMapping(value = "/following")
public class FollowingController {
	Logger logger = LoggerFactory.getLogger(FollowingController.class);
	
	@Autowired
	FollowingService followingService;
	
	@Autowired
	FollowingRepository followRepo;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addFollowers(@RequestBody FollowingRequest addFollowers){
		followingService.addFollowers(addFollowers);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{curentHandlerName}/{followingHandlerName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> removeFollowers(@PathVariable String curentHandlerName, @PathVariable String followingHandlerName){
		
		followingService.removeFollowers(curentHandlerName, followingHandlerName);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/{curentHandlerName}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFollowers(@PathVariable String curentHandlerName ){
		logger.info("inside get Followers method");
		return new ResponseEntity<>(followingService.getFollowers(curentHandlerName),HttpStatus.OK);
	}
	
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(){
		logger.info("inside find  All ");
		return ResponseEntity.ok(followRepo.findAll());
	}
	

}
