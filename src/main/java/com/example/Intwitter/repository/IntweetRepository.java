package com.example.Intwitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intwitter.entity.Intweet;

public interface IntweetRepository extends JpaRepository<Intweet, Long> 
{	
	//public List<Intweet> findAllByEmployeeIdOrderByIntweetDateDesc(List<Long> employeeId);
}
