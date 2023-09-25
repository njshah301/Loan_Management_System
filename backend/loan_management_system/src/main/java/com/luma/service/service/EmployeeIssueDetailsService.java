package com.luma.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeItemDetailsDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;

import jakarta.validation.Valid;

public interface EmployeeIssueDetailsService {

	ResponseEntity<String> applyLoan(ApplyLoanDto applyLoanDto);
	List<EmployeeItemDetailsDto> getAllEmployeesItemDetails();
	EmployeeItemDetailsDto getItemsByEmployeeId(Long empid);

}
