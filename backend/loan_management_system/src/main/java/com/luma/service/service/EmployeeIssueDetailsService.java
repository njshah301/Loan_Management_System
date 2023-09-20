package com.luma.service.service;

import org.springframework.http.ResponseEntity;

import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeItemDetailsDto;

import jakarta.validation.Valid;

public interface EmployeeIssueDetailsService {

	ResponseEntity<String> applyLoan(ApplyLoanDto applyLoanDto);

	EmployeeItemDetailsDto getItemsByEmployeeId(Long empid);

}
