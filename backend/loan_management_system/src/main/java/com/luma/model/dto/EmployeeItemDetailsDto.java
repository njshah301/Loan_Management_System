package com.luma.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeItemDetailsDto {
	private EmployeeRegisterDto employee;
	private List<EmployeeIssueDetailsDto> employeeIssueDetailsDto;
}
