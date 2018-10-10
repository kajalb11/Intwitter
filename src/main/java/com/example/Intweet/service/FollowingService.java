package com.example.Intweet.service;

import java.util.List;

import com.example.Intweet.model.FollowingRequest;

public interface FollowingService {

	
	public void addFollowers(FollowingRequest req);
	
	public void removeFollowers(String userHandler, String removerHandlerName);
	
	public List<String> getFollowers(String userHandler);
}
