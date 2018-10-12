package com.example.Intwitter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="INTWEET")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Intweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long intweetId;
	
	@Column(name="employee_id")
	private long employeeId;
	
	@Column(name="intweet_message")
	private String intweetMessage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "intweet_time", nullable = false)
	private Date intweetTime;
	
	@PrePersist
	public void prePersist() {
		Date dt = new Date();
		this.intweetTime = dt;
	}
}
