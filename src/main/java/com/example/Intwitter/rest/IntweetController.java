package com.example.Intwitter.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.model.IntweetRequest;

@RestController
@RequestMapping(value="/intweet")
public class IntweetController 
{

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> postTweet(@RequestBody IntweetRequest tweetRequest)
	{
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
