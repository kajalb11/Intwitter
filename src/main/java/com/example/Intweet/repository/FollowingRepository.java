package com.example.Intweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intweet.entity.Following;
import com.example.Intweet.entity.FollowingId;

public interface FollowingRepository extends JpaRepository<Following, FollowingId> {

	public List<Following> findByEmployeeId(long employeeId);
	
}
