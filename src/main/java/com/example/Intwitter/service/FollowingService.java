package com.example.Intwitter.service;

import java.util.List;

import com.example.Intwitter.model.FollowingRequest;

public interface FollowingService {

	
	public void follow(String followingIntweeterName);
	
	public void unfollow(String intweeterName, String followingIntweeterName);
	
	public List<String> getFollowers(String intweeterName);
}
