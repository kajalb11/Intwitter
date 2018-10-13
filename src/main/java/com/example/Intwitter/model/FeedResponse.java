package com.example.Intwitter.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedResponse 
{
	private String intweeterName;
	
	private String intweetMessage;
	
	private Date intweetTime;
}