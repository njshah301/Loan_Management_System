package com.luma.service.service;

import org.springframework.http.ResponseEntity;

import com.luma.model.dto.ApplyLoanDto;

import jakarta.validation.Valid;

public interface EmployeeIssueDetailsService {

	ResponseEntity<String> applyLoan(ApplyLoanDto applyLoanDto);

}