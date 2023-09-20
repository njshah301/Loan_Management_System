package com.luma.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.Employee_Card_Details;
import com.luma.model.Employee_Issue_Details;
import com.luma.model.Loan;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeCardDetailsDto;
import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoanDto;
import com.luma.repository.EmployeeCardDetailsRepository;
import com.luma.repository.EmployeeRepository;
import com.luma.repository.ItemRepository;
import com.luma.repository.LoanRepository;
import com.luma.service.service.EmployeeCardDetailsService;

import jakarta.validation.Valid;
@Service
public class EmployeeCardDetailsServiceImpl implements EmployeeCardDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeIssueDetailsServiceImpl.class);
	 @Autowired private EmployeeCardDetailsRepository employeeCardDetailsRepository;
		
	@Autowired private EmployeeRepository employeeRepository;
	
	
	
	
	
	@Autowired
	ModelMapper modelMapper;

	
	public Employee_Card_Details convertDtoToEntity2(EmployeeCardDetailsDto employeeCardDetailsDto)
	{
		logger.info("EmployeeCardDetailsServiceImpl: Entered inside convertDtoToEntity2() method");
		Employee_Card_Details employee_Card_Details= modelMapper.map(employeeCardDetailsDto, Employee_Card_Details.class);
		return employee_Card_Details;
	}
	
//	public EmployeeIssueDetailsDto convertEntityToDto(Employee_Card_Details employee_Card_Details)
//	{
//		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside convertEntityToDto() method");
//		EmployeeIssueDetailsDto employeeIssueDetailsDto= modelMapper.map(employee_Card_Details, EmployeeCardDetailsDto.class);
//		return employeeIssueDetailsDto;
//	}
//	
//	public EmployeeRegisterDto convertEntityToDto2(Employee employee)
//	{
//		logger.info("EmployeeIssueDetailsServiceImpl: Entered inside convertEntityToDto2() method");
//		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
//		employeeRegisterDto.setId(employee.getId());
//		return employeeRegisterDto;
//	}
	public EmployeeCardDetailsDto convertEntityToDto(Employee_Card_Details employee_Card_Details)
	{
		EmployeeCardDetailsDto employeeCardDetailsDto= modelMapper.map(employee_Card_Details, EmployeeCardDetailsDto.class);
		return employeeCardDetailsDto;
	}
	
	
	public LoanDto convertEntityToDto3(Loan loan)
	{
		LoanDto loanDto= modelMapper.map(loan, LoanDto.class);
		return loanDto;
	}

	
	public EmployeeRegisterDto convertEntityToDto2(Employee employee)
	{
		EmployeeRegisterDto employeeRegisterDto= modelMapper.map(employee, EmployeeRegisterDto.class);
		employeeRegisterDto.setId(employee.getId());
		return employeeRegisterDto;
	}
	
	
	@Override
	public EmployeeLoanDetailsDto getLoansByEmployeeId(Long empid) {
		Employee employee = employeeRepository.findByEmpid(empid).get();
		EmployeeRegisterDto employeeRegisterDto = convertEntityToDto2(employee);
		
		EmployeeLoanDetailsDto employeeLoanDetailsDto = new EmployeeLoanDetailsDto();
		
		employeeLoanDetailsDto.setEmployee(employeeRegisterDto);
		employeeLoanDetailsDto.setEmployeeCardDetailsDto(employee.getEmployee_Card_Details().stream().map(emp-> convertEntityToDto(emp)).collect(Collectors.toList())
);
		return employeeLoanDetailsDto;
	}

	@Override
	public void applyLoan(@Valid ApplyLoanDto applyLoanDto) {
		// TODO Auto-generated method stub
		EmployeeCardDetailsDto employeeCardDetailsDto = new EmployeeCardDetailsDto();
		Employee employee = employeeRepository.findByEmpid(applyLoanDto.getEmployee().getEmpid()).get();
		//EmployeeServiceImpl employeeServiceImpl= new EmployeeServiceImpl();
		employeeCardDetailsDto.setEmployee(convertEntityToDto2(employee));
		employeeCardDetailsDto.setIssueDate(new Date());
		employeeCardDetailsDto.setLoan(convertEntityToDto3(applyLoanDto.getLoan()));
//		employeeCardDetailsDto.setItem(applyLoanDto.getItem());
//		employeeCardDetailsDto.setReturn_date(LocalDate.now().plusYears(applyLoanDto.getLoan().getDuration()));
		
		 
		employeeCardDetailsRepository.save(convertDtoToEntity2(employeeCardDetailsDto));
		
	}

}
