package com.luma.model.dto;
import java.util.List;

import lombok.Data;
public class EmployeeLoanDetailsDto {
	private EmployeeRegisterDto employee;
	private List<EmployeeCardDetailsDto> employeeCardDetailsDto;
	public EmployeeRegisterDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeRegisterDto employee) {
		this.employee = employee;
	}
	public List<EmployeeCardDetailsDto> getEmployeeCardDetailsDto() {
		return employeeCardDetailsDto;
	}
	public void setEmployeeCardDetailsDto(List<EmployeeCardDetailsDto> employeeCardDetailsDto) {
		this.employeeCardDetailsDto = employeeCardDetailsDto;
	}
}
