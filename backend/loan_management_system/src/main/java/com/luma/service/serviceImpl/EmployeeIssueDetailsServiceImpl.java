package com.luma.service.serviceImpl;

import java.time.LocalDate;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.Employee_Issue_Details;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.repository.EmployeeIssueDetailsRepository;
import com.luma.repository.EmployeeRepository;
import com.luma.repository.ItemRepository;
import com.luma.repository.LoanRepository;
import com.luma.service.service.EmployeeIssueDetailsService;

@Service
public class EmployeeIssueDetailsServiceImpl implements EmployeeIssueDetailsService{
	@Autowired private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;
	
	@Autowired private ItemRepository itemRepository;
	@Autowired private LoanRepository loanRepository;
	@Autowired private EmployeeRepository employeeRepository;
	
	private EmployeeServiceImpl employeeServiceImpl;
	@Autowired
	ModelMapper modelMapper;
	public Employee_Issue_Details convertDtoToEntity(EmployeeIssueDetailsDto employeeIssueDetailsDto)
	{
		Employee_Issue_Details employee_Issue_Details= modelMapper.map(employeeIssueDetailsDto, Employee_Issue_Details.class);
		return employee_Issue_Details;
	}
	
	public EmployeeIssueDetailsDto convertEntityToDto(Employee_Issue_Details employee_Issue_Details)
	{
		EmployeeIssueDetailsDto employeeIssueDetailsDto= modelMapper.map(employee_Issue_Details, EmployeeIssueDetailsDto.class);
		return employeeIssueDetailsDto;
	}
	public EmployeeRegisterDto convertEntityToDto2(Employee employee)
	{
		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
		employeeRegisterDto.setId(employee.getId());
		return employeeRegisterDto;
	}
	@Override
	public ResponseEntity<String> applyLoan(ApplyLoanDto applyLoanDto) {
		// TODO Auto-generated method stub
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
}