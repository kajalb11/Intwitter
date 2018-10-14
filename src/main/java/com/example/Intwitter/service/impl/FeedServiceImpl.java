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
import com.example.Intwitter.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService
{
	Logger logger = LoggerFactory.getLogger(FeedServiceImpl.class);
	
	@Autowired
	IntweetRepository intweetRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	FollowingRepository followingRepo;
	
	//@Autowired
	//FeedResponse feedResponse;
		
	public List<FeedResponse> getFeed(String currentIntweeterName) 
	{
		logger.info("***** Inside FeedServiceImpl : getFeed *****");
		logger.info(" Logged In Intweeter Name : {} "+currentIntweeterName);
		List<Intweet> intweets = new ArrayList<>();

		List<FeedResponse> feedResponseList = new ArrayList<>();
		Long loggedInUserEmployeeId = empRepo.findByIntweeterName(currentIntweeterName).getEmployeeId();
		logger.info(" Logged In Intweeter Emp Id : {} "+loggedInUserEmployeeId);
	
		// Start Get My Followings - list of users followed by currentIntweeter
		List<Following> followingList = followingRepo.findByEmployeeId(loggedInUserEmployeeId);
		List<Long> followingEmpIdList = new ArrayList<>();
		logger.info(" Start followingEmpIdList : ");
		for (Following following : followingList) 
		{
			Long followingEmpId = following.getFollowingEmployeeId();
			logger.info(" {} : "+followingEmpId);
			followingEmpIdList.add(followingEmpId);
		}
		followingEmpIdList.add(loggedInUserEmployeeId); // Add logged in user as well as user see's self tweets posted as well
		logger.info(" End followingEmpIdList : ");
		// End: Get My followings Emp Id list
		
		//Start: Get Intweets posted by Logged in user's Followings
		logger.info(" Before  findByEmployeeIdInOrderByIntweetTimeDesc  ");
		intweets = intweetRepo.findByEmployeeIdInOrderByIntweetTimeDesc(followingEmpIdList);		
		logger.info(" After  findByEmployeeIdInOrderByIntweetTimeDesc  ");
		//End: Get Intweets posted by Logged in user's Followings
		
		// Start: Prepare getFeed Response
		for(Intweet intweet : intweets)
		{	
			String userName = empRepo.findById(intweet.getEmployeeId()).get().getIntweeterName();
			FeedResponse feedResponse = new FeedResponse();
			feedResponse.setIntweeterName(userName);
			feedResponse.setIntweetMessage(intweet.getIntweetMessage());
			feedResponse.setIntweetTime(intweet.getIntweetTime());
			feedResponseList.add(feedResponse);
		}		
		// End: Prepare getFeed Response
		
		return feedResponseList;
	}

}
