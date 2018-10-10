package com.example.Intweet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Intweet.entity.Employee;
import com.example.Intweet.entity.Following;
import com.example.Intweet.entity.FollowingId;
import com.example.Intweet.model.FollowingRequest;
import com.example.Intweet.repository.EmployeeRepository;
import com.example.Intweet.repository.FollowingRepository;
import com.example.Intweet.service.FollowingService;


@Service
public class FollowingServiceImpl implements FollowingService {
	Logger logger = LoggerFactory.getLogger(FollowingServiceImpl.class);
	@Autowired
	FollowingRepository follwoingRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	@Transactional
	public void addFollowers(FollowingRequest req) {
		
		String userHandleName = req.getIntweeterName();
		Employee currentUserDeatils = empRepo.findByIntweeterName(userHandleName);
		logger.info("employee id of current user {}" ,currentUserDeatils.getEmployeeId() );
		List<Employee>	followingEmployeeList = empRepo.findByIntweeterNameIn(req.getFollowersIntweeterName());
		logger.info("size of following list {}",followingEmployeeList.size());
		List<Following> followingList = new ArrayList<>();	
		for (Employee employee : followingEmployeeList) {
			logger.info("follower id {} " , employee.getEmployeeId());
			followingList.add(Following.builder().employeeId(currentUserDeatils.getEmployeeId()).followingEmployeeId(employee.getEmployeeId()).build());
		}
		
		follwoingRepo.saveAll(followingList);
	}

	@Override
	public void removeFollowers(String userHandler, String removerHandlerName) {
		Long currentUserID = empRepo.findByIntweeterName(userHandler).getEmployeeId();
		Long removingHandlerId = empRepo.findByIntweeterName(removerHandlerName).getEmployeeId();
		follwoingRepo.deleteById(FollowingId.builder().employeeId(currentUserID).followingEmployeeId(removingHandlerId).build());
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
