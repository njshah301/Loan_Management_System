package com.luma.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoginDto;
import com.luma.repository.EmployeeRepository;
import com.luma.service.service.EmployeeService;

import jakarta.validation.Valid;
@Service

public class EmployeeServiceImpl implements EmployeeService{
	
	private static final int ResponseEntity = 0;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	public void addEmployee(EmployeeRegisterDto employeeRegisterDto)
	{
		
		employeeRepository.save(convertDtoToEntity(employeeRegisterDto));
	}
	
	public Employee convertDtoToEntity(EmployeeRegisterDto employeeRegisterDto)
	{
		Employee employee= modelMapper.map(employeeRegisterDto, Employee.class);
		employee.setUsername(employeeRegisterDto.getEmpId()+"@LUMA");
		employee.setPassword("xyz@123");
		return employee;
	}
	
	public EmployeeRegisterDto convertEntityToDto(Employee employee)
	{
		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
		employeeRegisterDto.setId(employee.getId());
		return employeeRegisterDto;
	}

	@Override

	public List<EmployeeRegisterDto> getEmployees() {
		List<EmployeeRegisterDto> employeeRegisterDtos=  employeeRepository.findAll().stream().map(employee-> convertEntityToDto(employee)).collect(Collectors.toList());
		return employeeRegisterDtos;
	}

	@Override
	public void updateEmployee(EmployeeRegisterDto employeeRegisterDto,Long id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
		Employee emp = employee.get();
		emp.setBirthdate(employeeRegisterDto.getBirthdate());
		emp.setDepartment(employeeRegisterDto.getDepartment());
		emp.setDesignation(employeeRegisterDto.getDesignation());
		emp.setEmpId(employeeRegisterDto.getEmpId());
		emp.setGender(employeeRegisterDto.getGender());
		emp.setJoiningdate(employeeRegisterDto.getJoiningdate());
		emp.setName(employeeRegisterDto.getName());
		employeeRepository.save(emp);
		}
		
		
		
		
		
	}

	@Override
	public void deleteEmplooyee(@Valid Long id) {
		
		Employee employee = employeeRepository.findById(id).get();
		
		employeeRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<String> authUser(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Optional<Employee> empOptional= employeeRepository.findByUsernameAndPassword(loginDto.getUsername(),loginDto.getPassword());
		if(empOptional.isPresent())
		{
			return new ResponseEntity<String> (HttpStatus.OK);
		}
		return new ResponseEntity<String> (HttpStatus.FORBIDDEN) ;
	}

	@Override
	public EmployeeRegisterDto getEmployeesbyId(Long id) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeRepository.findById(id).get();
		EmployeeRegisterDto employeeRegisterDto= convertEntityToDto(employee);
		return employeeRegisterDto;
	}
	
}
