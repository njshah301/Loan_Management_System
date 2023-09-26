package com.luma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.ChangeCredentialDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.service.service.EmployeeService;

import jakarta.validation.Valid;

@RequestMapping("/api/employee")
@RestController
@CrossOrigin	
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<EmployeeRegisterDto> getEmployees()
	{
		logger.info("EmployeeController: Entered inside getEmployees() method");
		List<EmployeeRegisterDto> employeeRegisterDtos=employeeService.getEmployees();
		return employeeRegisterDtos;
	}
	
	@GetMapping(path="{id}")
	public EmployeeRegisterDto getEmployeesById(@PathVariable Long id)
	{
		logger.info("EmployeeController: Entered inside getEmployeesById() method");
		EmployeeRegisterDto employeeRegisterDto=employeeService.getEmployeesbyId(id);
		return employeeRegisterDto;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeRegisterDto employeeRegisteDto)
	{
		logger.info("EmployeeController: Entered inside addEmployee() method");
		employeeService.addEmployee(employeeRegisteDto);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@Valid @PathVariable Long id,@RequestBody EmployeeRegisterDto employeeRegisterDto)
	{
		logger.info("EmployeeController: Entered inside updateEmployee() method");
		employeeService.updateEmployee(employeeRegisterDto,id);
	}
	@PutMapping("/resetPassword/{id}")
	public void updateEmployeePassword(@Valid @PathVariable Long id,@RequestBody ChangeCredentialDto changeCredentialDto)
	{
		logger.info("EmployeeController: Entered inside updateEmployeePassword() method");
		employeeService.updateEmployeePassword(changeCredentialDto,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@Valid @PathVariable Long id)
	{
		logger.warn("EmployeeController: Entered inside deleteEmployee() method");
		employeeService.deleteEmplooyee(id);
	}	
}
