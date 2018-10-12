package com.example.Intwitter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intwitter.entity.Employee;
import com.example.Intwitter.entity.Following;
import com.example.Intwitter.entity.FollowingId;
import com.example.Intwitter.model.FollowingRequest;
import com.example.Intwitter.repository.EmployeeRepository;
import com.example.Intwitter.repository.FollowingRepository;
import com.example.Intwitter.service.FollowingService;


@Service
public class FollowingServiceImpl implements FollowingService {
	Logger logger = LoggerFactory.getLogger(FollowingServiceImpl.class);
	@Autowired
	FollowingRepository follwoingRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	@Transactional
	public void follow(FollowingRequest req) {
		
		String intweeterName = req.getIntweeterName();
		Employee currentUserDetails = empRepo.findByIntweeterName(intweeterName);
		Long loggedInUserEmployeeId = currentUserDetails.getEmployeeId();
		logger.info("employee id of current logged in user {}", loggedInUserEmployeeId);

		String followingIntweeterName = req.getFollowingIntweeterName();
		Employee followingUserDetails = empRepo.findByIntweeterName(followingIntweeterName);
		Long followingUserEmployeeId = followingUserDetails.getEmployeeId();
		logger.info("employee id of following user {}", followingUserEmployeeId);
		
		Following following = new Following();
		following.setEmployeeId(loggedInUserEmployeeId);
		following.setFollowingEmployeeId(followingUserEmployeeId);
		
		follwoingRepo.save(following);
		
		/* 
		 List<Employee>	followingEmployeeList = empRepo.findByIntweeterNameIn(req.getFollowingIntweeterName());
		logger.info("size of following list {}",followingEmployeeList.size());
		List<Following> followingList = new ArrayList<>();	
		for (Employee employee : followingEmployeeList) {
			logger.info("follower id {} " , employee.getEmployeeId());
			followingList.add(Following.builder().employeeId(currentUserDetails.getEmployeeId()).followingEmployeeId(employee.getEmployeeId()).build());
		}
		 */
	}

	@Override
	public void unfollow(FollowingRequest req) 
	{
		String intweeterName = req.getIntweeterName();
		Employee currentUserDetails = empRepo.findByIntweeterName(intweeterName);
		Long loggedInUserEmployeeId = currentUserDetails.getEmployeeId();
		logger.info("employee id of current logged in user {}", loggedInUserEmployeeId);

		String followingIntweeterName = req.getFollowingIntweeterName();
		Employee followingUserDetails = empRepo.findByIntweeterName(followingIntweeterName);
		Long followingUserEmployeeId = followingUserDetails.getEmployeeId();
		logger.info("employee id of following user {}", followingUserEmployeeId);
		
		Following following = new Following();
		following.setEmployeeId(loggedInUserEmployeeId);
		following.setFollowingEmployeeId(followingUserEmployeeId);
		
		//Long currentUserID = empRepo.findByIntweeterName(userHandler).getEmployeeId();
		//Long removingHandlerId = empRepo.findByIntweeterName(removerHandlerName).getEmployeeId();
		follwoingRepo.deleteById(FollowingId.builder().employeeId(loggedInUserEmployeeId).followingEmployeeId(followingUserEmployeeId).build());
	}

	@Override
	public List<String> getFollowers(String userHandler) {
		Long currentUserId = empRepo.findByIntweeterName(userHandler).getEmployeeId();
		List<Following> follwingList = follwoingRepo.findByEmployeeId(currentUserId);
		List<String> followingUserList = new ArrayList<>();
		for (Following following : follwingList) {
			String userName = empRepo.findById(following.getEmployeeId()).get().getIntweeterName();
			followingUserList.add(userName);
		}
		return followingUserList;
	}

}
