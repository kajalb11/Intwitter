package com.example.Intweet.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FollowingRequest {
	
	private String intweeterName;
	
	private List<String> followersIntweeterName;

}
