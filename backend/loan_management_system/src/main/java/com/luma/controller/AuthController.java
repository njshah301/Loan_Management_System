package com.luma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.JwtAuthResponse;
import com.luma.model.dto.LoginDto;
import com.luma.service.service.AuthService;
import com.luma.service.service.EmployeeCardDetailsService;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin

public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
@Autowired
UserDetailsService userService;
//	@Autowired
//	private EmployeeService employeeService;
//	
	@Autowired
	private EmployeeCardDetailsService employeeCardDetailsService;
//	@PostMapping
//	private ResponseEntity<String> authUser(@RequestBody LoginDto loginDto)
//	{
//		logger.info("AuthController: Entered inside authUser() method");
//		return employeeService.authUser(loginDto);
//	}
	@PostMapping("/setStatus/{loan_id}")
	private void setLoanStatus(@PathVariable Long loan_id,@RequestParam String status)
	{
		employeeCardDetailsService.setLoanStatus(loan_id,status);
	}
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
//		System.out.println("Inside Login controller");
//		String token=authService.login(loginDto);
//		JwtAuthResponse response=new JwtAuthResponse();
//		response.setAccessToken(token);
//		return ResponseEntity.ok(response);
//	}
	public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
		System.out.println(loginDto);
		
		String token = authService.login(loginDto);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setAccessToken(token);
		
		UserDetails userDetails = userService.loadUserByUsername(loginDto.getUsernameOrEmail());
		
		response.setRole(userDetails.getAuthorities().toArray()[0].toString());
		
		return ResponseEntity.ok(response);
	}

}
