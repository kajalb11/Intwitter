package com.example.Intwitter.service;

import java.util.List;

import com.example.Intwitter.entity.Intweet;
import com.example.Intwitter.model.FeedResponse;

public interface FeedService 
{
	public List<FeedResponse> getFeed(String currentIntweeterName, int page ,int limit);
}
