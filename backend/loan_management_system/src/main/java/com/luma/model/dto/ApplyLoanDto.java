package com.luma.model.dto;

import com.luma.model.Loan;

import lombok.Data;
@Data
public class ApplyLoanDto {
	private EmployeeRegisterDto employee;
	private ItemDto item;
	private Loan loan;
}





