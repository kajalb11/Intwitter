package com.example.Intwitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.model.FollowingRequest;
import com.example.Intwitter.repository.FollowingRepository;
import com.example.Intwitter.service.FollowingService;

@RestController
//@RequestMapping(value = "/following")
public class FollowingController {
	Logger logger = LoggerFactory.getLogger(FollowingController.class);
	
	@Autowired
	FollowingService followingService;
	
	@Autowired
	FollowingRepository followingRepo;
	
	@RequestMapping(value = "/follow")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> follow(@RequestBody FollowingRequest followIntweeterName){
		followingService.follow(followIntweeterName);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/{curentIntweeterName}/{followingIntweeterName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> removeFollowers(@PathVariable String curentIntweeterName, @PathVariable String followingIntweeterName){
		
		followingService.removeFollowers(curentIntweeterName, followingIntweeterName);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/{curentIntweeterName}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFollowers(@PathVariable String curentIntweeterName ){
		logger.info("inside get Followers method");
		return new ResponseEntity<>(followingService.getFollowers(curentIntweeterName),HttpStatus.OK);
	}
	
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(){
		logger.info("inside find  All ");
		return ResponseEntity.ok(followingRepo.findAll());
	}
	

}
