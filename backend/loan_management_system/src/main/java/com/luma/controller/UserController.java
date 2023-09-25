package com.luma.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.Employee_Card_Details;
import com.luma.model.Loan;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeItemDetailsDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.service.service.EmployeeIssueDetailsService;
import com.luma.service.service.EmployeeCardDetailsService;

import jakarta.validation.Valid;
@RequestMapping("/api/user")
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private EmployeeIssueDetailsService employeeIssueDetailsService;
	
	@Autowired
	private EmployeeCardDetailsService employeeCardDetailsService;
	
	
	
	@GetMapping("/{empid}")
	public EmployeeItemDetailsDto getItemsByEmployeeId(@PathVariable Long empid)
	{
		return employeeIssueDetailsService.getItemsByEmployeeId(empid);
		
	}

	@PostMapping
	public ResponseEntity<String> applyLoan(@Valid @RequestBody ApplyLoanDto applyLoanDto)
	{
		employeeIssueDetailsService.applyLoan(applyLoanDto);
		employeeCardDetailsService.applyLoan(applyLoanDto);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
	

	@GetMapping("/cards/{empid}")
	public EmployeeLoanDetailsDto getLoansByEmployeeId(@PathVariable Long empid){
		return employeeCardDetailsService.getLoansByEmployeeId(empid);
	}
	
	@GetMapping("/loans")
	List<EmployeeLoanDetailsDto> getAllEmployeesLoanDetails(){
		return employeeCardDetailsService.getAllEmployeesLoanDetails();
	}
	
	@GetMapping("/items")
	List<EmployeeItemDetailsDto> getAllEmployeesItemDetails(){
		return employeeIssueDetailsService.getAllEmployeesItemDetails();
	}
}
