package com.luma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.service.service.EmployeeIssueDetailsService;

import jakarta.validation.Valid;

@RequestMapping("/api/user")
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private EmployeeIssueDetailsService employeeIssueDetailsService;
	@PostMapping
	public ResponseEntity<String> applyLoan(@Valid @RequestBody ApplyLoanDto applyLoanDto)
	{
		employeeIssueDetailsService.applyLoan(applyLoanDto);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
}
