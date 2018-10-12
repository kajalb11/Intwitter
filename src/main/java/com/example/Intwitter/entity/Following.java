package com.example.Intwitter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="FOLLOWING")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(value=FollowingId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Following {
	
	@Id
	@Column(name="employee_id")
	private long employeeId;
	
	@Id
	@Column(name="following_emp_id")
	private long followingEmployeeId;

}
