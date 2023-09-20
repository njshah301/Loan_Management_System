package com.luma.service.service;

import java.util.List;

import com.luma.model.Loan;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;

import jakarta.validation.Valid;

public interface EmployeeCardDetailsService {
	EmployeeLoanDetailsDto getLoansByEmployeeId(Long empid);

	void applyLoan(@Valid ApplyLoanDto applyLoanDto);
}
