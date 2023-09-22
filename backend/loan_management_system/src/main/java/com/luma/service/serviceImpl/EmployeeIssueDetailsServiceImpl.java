package com.luma.service.serviceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.Employee_Issue_Details;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeItemDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.repository.EmployeeIssueDetailsRepository;
import com.luma.repository.EmployeeRepository;
import com.luma.repository.ItemRepository;
import com.luma.repository.LoanRepository;
import com.luma.service.service.EmployeeIssueDetailsService;

@Service
public class EmployeeIssueDetailsServiceImpl implements EmployeeIssueDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeIssueDetailsServiceImpl.class);

	@Autowired private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;
	
	@Autowired private ItemRepository itemRepository;
	@Autowired private LoanRepository loanRepository;
	@Autowired private EmployeeRepository employeeRepository;
	
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	ModelMapper modelMapper;
	
	public Employee_Issue_Details convertDtoToEntity(EmployeeIssueDetailsDto employeeIssueDetailsDto)
	{
		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside convertDtoToEntity() method");
		Employee_Issue_Details employee_Issue_Details= modelMapper.map(employeeIssueDetailsDto, Employee_Issue_Details.class);
		return employee_Issue_Details;
	}
	
	public EmployeeIssueDetailsDto convertEntityToDto(Employee_Issue_Details employee_Issue_Details)
	{
		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside convertEntityToDto() method");
		EmployeeIssueDetailsDto employeeIssueDetailsDto= modelMapper.map(employee_Issue_Details, EmployeeIssueDetailsDto.class);
		return employeeIssueDetailsDto;
	}
	
	public EmployeeRegisterDto convertEntityToDto2(Employee employee)
	{
		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside convertEntityToDto2() method");
		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
		employeeRegisterDto.setId(employee.getId());
		return employeeRegisterDto;
	}
	
	@Override
	public ResponseEntity<String> applyLoan(ApplyLoanDto applyLoanDto) {
		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside applyLoan() method");
		EmployeeIssueDetailsDto employeeIssueDetailsDto = new EmployeeIssueDetailsDto();
		//EmployeeServiceImpl employeeServiceImpl= new EmployeeServiceImpl();
		Employee employee= employeeRepository.findByEmpid(applyLoanDto.getEmployee().getEmpid()).get(); 
		employeeIssueDetailsDto.setEmployee(convertEntityToDto2(employee));
		employeeIssueDetailsDto.setIssueDate(new Date());
		
		
		employeeIssueDetailsDto.setItem(applyLoanDto.getItem());
		employeeIssueDetailsDto.setReturn_date(LocalDate.now().plusYears(applyLoanDto.getLoan().getDuration()));
		
		 
	 	Employee_Issue_Details employeeIssue= convertDtoToEntity(employeeIssueDetailsDto);
	 	
	 	employeeIssueDetailsRepository.save(employeeIssue);
	 	
	    return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@Override
	public EmployeeItemDetailsDto getItemsByEmployeeId(Long empid) {
		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside getItemsByEmployeeId() method");
		Employee employee = employeeRepository.findByEmpid(empid).get();
		EmployeeRegisterDto employeeRegisterDto = convertEntityToDto2(employee);
		
		EmployeeItemDetailsDto employeeItemDetailsDto = new EmployeeItemDetailsDto();
		
		employeeItemDetailsDto.setEmployee(employeeRegisterDto);
		employeeItemDetailsDto.setEmployeeIssueDetailsDto(employee.getEmployee_Issue_Details().stream().map(emp-> convertEntityToDto(emp)).collect(Collectors.toList())
);
		return employeeItemDetailsDto;
	}
}