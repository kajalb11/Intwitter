package com.example.Intwitter.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedResponse 
{
	private String intweeterName;
	
	private String intweetMessage;
	
	private Date intweetTime;
}