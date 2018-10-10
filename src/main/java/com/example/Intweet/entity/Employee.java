package com.example.Intweet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8787146733213815350L;

	@Id
	@Column(name="employee_id",unique=true,nullable=false)
	private Long employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="handler_name", unique=true)
	private String intweeterName;
}
