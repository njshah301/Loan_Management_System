package com.luma.controller;

import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.LoginDto;
import com.luma.service.service.EmployeeCardDetailsService;
import com.luma.service.service.EmployeeService;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin

public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeCardDetailsService employeeCardDetailsService;
	@PostMapping
	private ResponseEntity<String> authUser(@RequestBody LoginDto loginDto)
	{
		logger.info("AuthController: Entered inside authUser() method");
		return employeeService.authUser(loginDto);
	}
	@PostMapping("/setStatus/{loan_id}")
	private void setLoanStatus(@PathVariable Long loan_id,@RequestParam String status)
	{
		employeeCardDetailsService.setLoanStatus(loan_id,status);
	}
	
	
}
