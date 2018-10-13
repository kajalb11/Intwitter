package com.example.Intwitter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intwitter.entity.Following;
import com.example.Intwitter.entity.Intweet;
import com.example.Intwitter.model.FeedResponse;
import com.example.Intwitter.repository.EmployeeRepository;
import com.example.Intwitter.repository.FollowingRepository;
import com.example.Intwitter.repository.IntweetRepository;

@Service
public class FeedServiceImpl 
{
	Logger logger = LoggerFactory.getLogger(FeedServiceImpl.class);
	
	//@Autowired
	//IntweetRepository intweetRepo;
	
	//@Autowired
	//EmployeeRepository empRepo;
	
	//@Autowired
	//FollowingRepository followingRepo;
	
	//@Autowired
	//private FollowingServiceImpl followingServiceImpl;
	
	public List<Intweet> getFeed(String currentIntweeterName) 
	{
		logger.info("Inside FeedServiceImpl : getFeed : {} "+currentIntweeterName);
		List<Intweet> intweets = new ArrayList<>();
		//List<FeedResponse> feedResponse = new ArrayList<>();
		//Long loggedInUserEmployeeId = empRepo.findByIntweeterName(currentIntweeterName).getEmployeeId();
	
		// Start Get My Followings - list of users followed by currentIntweeter
	/*
		List<Following> followingList = followingRepo.findByEmployeeId(loggedInUserEmployeeId);
		List<Long> followingEmpIdList = new ArrayList<>();
		for (Following following : followingList) 
		{
			long followingEmpId = following.getFollowingEmployeeId();
			followingEmpIdList.add(followingEmpId);
		}
	*/
		// End: Get My followings Emp Id list
		
		//Start: Get Intweets posted by Logged in user's Followings
		
	//	intweets = intweetRepo.findAllByEmployeeIdOrderByIntweetDateDesc(followingEmpIdList);		
		//End: Get Intweets posted by Logged in user's Followings
		
		// Start: Prepare getFeed Response
		/*
		for(Intweet intweet : intweets)
		{
			String userName = empRepo.findById(intweet.getEmployeeId()).get().getIntweeterName();
			feedResponse.set(index, element)
			
		}
		// End: Prepare getFeed Response
		//return feedResponse;
		 */
		return intweets;
	}

}
