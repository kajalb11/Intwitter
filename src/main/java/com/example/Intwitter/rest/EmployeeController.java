package com.example.Intwitter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Intwitter.entity.Employee;
import com.example.Intwitter.service.EmployeeService;



@RestController
@RequestMapping(value ="/employee")
public class EmployeeController {
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService empService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		logger.info("--inside employee controller --");
		logger.debug("testing debug");
		empService.saveEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{employeeId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId){
		  
		return new ResponseEntity<>(
				empService.getEmployeeById(employeeId), HttpStatus.OK);
	}

}
