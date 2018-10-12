package com.example.Intwitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intwitter.entity.Following;
import com.example.Intwitter.entity.FollowingId;

public interface FollowingRepository extends JpaRepository<Following, FollowingId> 
{
	public List<Following> findByEmployeeId(long employeeId);
	
}
