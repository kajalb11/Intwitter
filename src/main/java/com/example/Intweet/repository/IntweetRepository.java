package com.example.Intweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Intweet.entity.InTweet;

public interface IntweetRepository extends JpaRepository<InTweet, Long> {

}
