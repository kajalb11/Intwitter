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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.model.FollowingRequest;
import com.example.Intwitter.repository.FollowingRepository;
import com.example.Intwitter.service.FollowingService;

@RestController
//@RequestMapping(value = "/following")
public class FollowingController 
{
	Logger logger = LoggerFactory.getLogger(FollowingController.class);
	
	@Autowired
	FollowingService followingService;
	
	@Autowired
	FollowingRepository followingRepo;
	
	@RequestMapping(value = "/follow")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> follow(@RequestBody FollowingRequest followReq)
	{
		followingService.follow(followReq);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//@DeleteMapping(value="/{curentIntweeterName}/{followingIntweeterName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<?> removeFollowers(@PathVariable String curentIntweeterName, @PathVariable String followingIntweeterName)
	@RequestMapping(value = "/unfollow")
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> unfollow(@RequestBody FollowingRequest unfollowReq)
	{
		followingService.unfollow(unfollowReq);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/getAllFollowings")
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllFollowings()
	{
		logger.info("inside getAllFollowings ");
		return ResponseEntity.ok(followingRepo.findAll());
	}
	
	@GetMapping(value="/getMyFollowings/{currentIntweeterName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMyFollowings(@PathVariable String currentIntweeterName )
	{
		logger.info("Inside FollowingController: getMyFollowings {} ", currentIntweeterName);
		return new ResponseEntity<>(followingService.getMyFollowings(currentIntweeterName),HttpStatus.OK);
	}
	
	@GetMapping(value="/getMyFollowers/{currentIntweeterName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMyFollowers(@PathVariable String currentIntweeterName )
	{
		logger.info("Inside FollowingController: getMyFollowers {}", currentIntweeterName);
		return new ResponseEntity<>(followingService.getMyFollowers(currentIntweeterName),HttpStatus.OK);
	}
}
