package com.luma.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.dto.ChangeCredentialDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoginDto;

import jakarta.validation.Valid;

public interface EmployeeService {
	public void addEmployee(EmployeeRegisterDto employeeRegisteDto);

	public List<EmployeeRegisterDto> getEmployees();

	public void updateEmployee(EmployeeRegisterDto employeeRegisterDto,Long id);

	public void deleteEmplooyee(@Valid Long id);

	public ResponseEntity<String> authUser(LoginDto loginDto);

	public EmployeeRegisterDto getEmployeesbyId(Long id);

	public void updateEmployeePassword(ChangeCredentialDto changeCredentialDto, Long id);
}	
