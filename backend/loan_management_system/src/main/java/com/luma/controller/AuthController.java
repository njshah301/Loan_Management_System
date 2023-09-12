package com.luma.controller;

import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.LoginDto;
import com.luma.service.service.EmployeeService;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin

public class AuthController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	private ResponseEntity<String> authUser(@RequestBody LoginDto loginDto)
	{
		return employeeService.authUser(loginDto);
	}
	
	
}
