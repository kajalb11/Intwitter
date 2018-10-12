package com.example.Intwitter.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class FollowingId implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long employeeId;
	private long followingEmployeeId;
}
