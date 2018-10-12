package com.example.Intwitter.service;

import java.util.List;

import com.example.Intwitter.model.FollowingRequest;

public interface FollowingService 
{
	
	public void follow(FollowingRequest followReq);
	
	public void unfollow(FollowingRequest unfollowReq);
	
	public List<String> getMyFollowings(String intweeterName);
	
}
