package com.luma.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.controller.EmployeeController;
import com.luma.model.Employee;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoginDto;
import com.luma.repository.EmployeeRepository;
import com.luma.service.service.EmployeeService;

import jakarta.validation.Valid;
@Service

public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public void addEmployee(EmployeeRegisterDto employeeRegisterDto)
	{
		logger.info("EmployeeServiceImpl: Entered inside addEmployee() method");
		employeeRepository.save(convertDtoToEntity(employeeRegisterDto));
	}
	
	public Employee convertDtoToEntity(EmployeeRegisterDto employeeRegisterDto)
	{
		logger.info("EmployeeServiceImpl: Entered inside convertDtoToEntity() method");
		Employee employee= modelMapper.map(employeeRegisterDto, Employee.class);
		employee.setUsername(employeeRegisterDto.getEmpid()+"@LUMA");
		employee.setPassword("xyz@123");
		return employee;
	}
	
	public EmployeeRegisterDto convertEntityToDto(Employee employee)
	{
		logger.info("EmployeeServiceImpl: Entered inside convertEntityToDto() method");
		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
		employeeRegisterDto.setId(employee.getId());
		return employeeRegisterDto;
	}

	@Override
	public List<EmployeeRegisterDto> getEmployees() {
		logger.info("EmployeeServiceImpl: Entered inside getEmployees() method");
		List<EmployeeRegisterDto> employeeRegisterDtos=  employeeRepository.findAll().stream().map(employee-> convertEntityToDto(employee)).collect(Collectors.toList());
		return employeeRegisterDtos;
	}

	@Override
	public void updateEmployee(EmployeeRegisterDto employeeRegisterDto,Long id) {
		logger.info("EmployeeServiceImpl: Entered inside updateEmployee() method");
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			Employee emp = employee.get();
			emp.setBirthdate(employeeRegisterDto.getBirthdate());
			emp.setDepartment(employeeRegisterDto.getDepartment());
			emp.setDesignation(employeeRegisterDto.getDesignation());
			emp.setEmpid(employeeRegisterDto.getEmpid());
			emp.setGender(employeeRegisterDto.getGender());
			emp.setJoiningdate(employeeRegisterDto.getJoiningdate());
			emp.setName(employeeRegisterDto.getName());
			employeeRepository.save(emp);
		}
	}

	@Override
	public void deleteEmplooyee(@Valid Long id) {
		logger.warn("EmployeeServiceImpl: Entered inside deleteEmployee() method");
		employeeRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<String> authUser(LoginDto loginDto) {
		logger.info("EmployeeServiceImpl: Entered inside authUser() method");
		Optional<Employee> empOptional= employeeRepository.findByUsernameAndPassword(loginDto.getUsername(),loginDto.getPassword());
		if(empOptional.isPresent())
		{
			return new ResponseEntity<String> (HttpStatus.OK);
		}
		return new ResponseEntity<String> (HttpStatus.FORBIDDEN) ;
	}

	@Override
	public EmployeeRegisterDto getEmployeesbyId(Long id) {
		logger.info("EmployeeServiceImpl: Entered inside getEmployeeById() method");
		Employee employee = employeeRepository.findById(id).get();
		EmployeeRegisterDto employeeRegisterDto= convertEntityToDto(employee);
		return employeeRegisterDto;
	}
}
