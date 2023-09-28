//package com.luma.service.serviceImpl;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.luma.controller.EmployeeController;
//import com.luma.model.Employee;
//import com.luma.model.dto.EmployeeRegisterDto;
//import com.luma.model.dto.LoginDto;
//import com.luma.repository.EmployeeRepository;
//import com.luma.service.service.EmployeeService;
//
//import jakarta.validation.Valid;
//@Service
//
//public class EmployeeServiceImpl implements EmployeeService{
//	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
//
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
//	@Autowired
//	ModelMapper modelMapper;
//	
//	public void addEmployee(EmployeeRegisterDto employeeRegisterDto)
//	{
//		logger.info("EmployeeServiceImpl: Entered inside addEmployee() method");
//		employeeRepository.save(convertDtoToEntity(employeeRegisterDto));
//	}
//	
//	public Employee convertDtoToEntity(EmployeeRegisterDto employeeRegisterDto)
//	{
//		logger.info("EmployeeServiceImpl: Entered inside convertDtoToEntity() method");
//		Employee employee= modelMapper.map(employeeRegisterDto, Employee.class);
//		employee.setUsername(employeeRegisterDto.getEmpid()+"@LUMA");
//		employee.setPassword("xyz@123");
//		return employee;
//	}
//	
//	public EmployeeRegisterDto convertEntityToDto(Employee employee)
//	{
//		logger.info("EmployeeServiceImpl: Entered inside convertEntityToDto() method");
//		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
//		employeeRegisterDto.setId(employee.getId());
//		return employeeRegisterDto;
//	}
//
//	@Override
//	public List<EmployeeRegisterDto> getEmployees() {
//		logger.info("EmployeeServiceImpl: Entered inside getEmployees() method");
//		List<EmployeeRegisterDto> employeeRegisterDtos=  employeeRepository.findAll().stream().map(employee-> convertEntityToDto(employee)).collect(Collectors.toList());
//		return employeeRegisterDtos;
//	}
//
//	@Override
//	public void updateEmployee(EmployeeRegisterDto employeeRegisterDto,Long id) {
//		logger.info("EmployeeServiceImpl: Entered inside updateEmployee() method");
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent())
//		{
//			Employee emp = employee.get();
//			emp.setBirthdate(employeeRegisterDto.getBirthdate());
//			emp.setDepartment(employeeRegisterDto.getDepartment());
//			emp.setDesignation(employeeRegisterDto.getDesignation());
//			emp.setEmpid(employeeRegisterDto.getEmpid());
//			emp.setGender(employeeRegisterDto.getGender());
//			emp.setJoiningdate(employeeRegisterDto.getJoiningdate());
//			emp.setName(employeeRegisterDto.getName());
//			employeeRepository.save(emp);
//		}
//	}
//
//	@Override
//	public void deleteEmplooyee(@Valid Long id) {
//		logger.warn("EmployeeServiceImpl: Entered inside deleteEmployee() method");
//		employeeRepository.deleteById(id);
//	}
//
//	@Override
//	public ResponseEntity<String> authUser(LoginDto loginDto) {
//		logger.info("EmployeeServiceImpl: Entered inside authUser() method");
//		Optional<Employee> empOptional= employeeRepository.findByUsernameAndPassword(loginDto.getUsernameOrEmail(),loginDto.getPassword());
//		if(empOptional.isPresent())
//		{
//			return new ResponseEntity<String> (HttpStatus.OK);
//		}
//		return new ResponseEntity<String> (HttpStatus.FORBIDDEN) ;
//	}
//
//	@Override
//	public EmployeeRegisterDto getEmployeesbyId(Long id) {
//		logger.info("EmployeeServiceImpl: Entered inside getEmployeeById() method");
//		Employee employee = employeeRepository.findById(id).get();
//		EmployeeRegisterDto employeeRegisterDto= convertEntityToDto(employee);
//		return employeeRegisterDto;
//	}
//}

package com.luma.service.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.Role;
import com.luma.model.User;
import com.luma.model.dto.ChangeCredentialDto;
import com.luma.model.dto.EmployeeDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoginDto;
import com.luma.repository.EmployeeRepository;
import com.luma.repository.UserRepository;
import com.luma.service.service.EmployeeService;

import jakarta.validation.Valid;
@Service

public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public void addEmployee(EmployeeRegisterDto employeeRegisterDto)
	{
		logger.info("EmployeeServiceImpl: Entered inside addEmployee() method");
		User user = new User();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		Role role = new Role();
		Set<Role> roles = new HashSet<Role>();
		user.setId(employeeRegisterDto.getEmpid());
		user.setEmail(employeeRegisterDto.getName()+"@gmail.com");
		user.setPassword(encoder.encode(employeeRegisterDto.getEmpid()+"@123"));
		user.setUsername(employeeRegisterDto.getEmpid()+"@BRENS");
		user.setName(employeeRegisterDto.getName());

		role.setId(2);
		role.setName("USER");
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
		employeeRepository.save(convertDtoToEntity(employeeRegisterDto));
	}
	
	public Employee convertDtoToEntity(EmployeeRegisterDto employeeRegisterDto)
	{
		logger.info("EmployeeServiceImpl: Entered inside convertDtoToEntity() method");
		Employee employee= modelMapper.map(employeeRegisterDto, Employee.class);
		employee.setUsername(employeeRegisterDto.getEmpid()+"@BRENS");
		employee.setPassword(employeeRegisterDto.getEmpid()+"@123");
		return employee;
	}
	
	public Employee convertDtoToEntity2(EmployeeDto employeeDto)
	{
		logger.info("EmployeeServiceImpl: Entered inside convertDtoToEntity2() method");
		Employee employee= modelMapper.map(employeeDto, Employee.class);
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
		User user = new User();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		Role role = new Role();
		Set<Role> roles = new HashSet<Role>();
		user.setId(employeeRegisterDto.getEmpid());

		user.setPassword(encoder.encode(employeeRegisterDto.getEmpid()+"@123"));
		user.setUsername(employeeRegisterDto.getEmpid()+"@BRENS");

		role.setId(2);
		role.setName("USER");
		user.setName(employeeRegisterDto.getName());
		roles.add(role);
		user.setRoles(roles);
//		user.setId(employeeRegisterDto.getId());
		user.setEmail(employeeRegisterDto.getName()+"@gmail.com");

		userRepository.save(user);

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
		userRepository.deleteById(employeeRepository.findById(id).get().getEmpid());
		employeeRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<String> authUser(LoginDto loginDto) {
		logger.info("EmployeeServiceImpl: Entered inside authUser() method");
		Optional<Employee> empOptional= employeeRepository.findByUsernameAndPassword(loginDto.getUsernameOrEmail(),loginDto.getPassword());
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

	@Override
	public void updateEmployeePassword(ChangeCredentialDto changeCredentialDto, Long id) {
		// TODO Auto-generated method stub
		Employee employee= employeeRepository.findById(id).get();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		employee.setPassword(changeCredentialDto.getPassword());
		Optional<User> user = userRepository.findById(employee.getEmpid());
		user.get().setPassword(encoder.encode(changeCredentialDto.getPassword()));
		userRepository.save(user.get());
		
	}

	@Override
	public EmployeeRegisterDto getEmployeesbyEmpId(Long empid) {
		// TODO Auto-generated method stub
		logger.info("EmployeeServiceImpl: Entered inside getEmployeeById() method");
		Employee employee = employeeRepository.findByEmpid(empid).get();
		EmployeeRegisterDto employeeRegisterDto= convertEntityToDto(employee);
		return employeeRegisterDto;
		
	}
}