package com.luma.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.luma.model.Employee;
import com.luma.model.Employee_Card_Details;
import com.luma.model.Loan;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeCardDetailsDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.ItemDto;
import com.luma.model.dto.LoanDto;
import com.luma.repository.EmployeeCardDetailsRepository;
import com.luma.repository.EmployeeRepository;
import com.luma.service.serviceImpl.EmployeeCardDetailsServiceImpl;

public class EmployeeCardDetailsServiceTest {

    @Mock
    private EmployeeCardDetailsRepository employeeCardDetailsRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeCardDetailsServiceImpl employeeCardDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetLoansByEmployeeId() {
        // Mocking data
        Long empid = 2151587L;
        Employee employee = new Employee();
        employee.setId(1L);
        
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();
        employeeRegisterDto.setEmpid(empid);
        employeeRegisterDto.setId(1L);
        LoanDto loan = new LoanDto();
        loan.setLoan_id(1L);
        Employee_Card_Details cardDetails = new Employee_Card_Details();
        cardDetails.setCard_id(1L);
        EmployeeCardDetailsDto cardDetailsDto= new EmployeeCardDetailsDto();
        List <Employee_Card_Details> employee_Card_Details=new ArrayList();
        employee_Card_Details.add(cardDetails);
        employee.setEmployee_Card_Details(employee_Card_Details);
        cardDetailsDto.setCard_id(1L);
        cardDetailsDto.setEmployee(employeeRegisterDto);
        cardDetailsDto.setIssueDate(new Date(0));cardDetailsDto.setLoan(loan);
        cardDetailsDto.setStatus("Yes");
        List<Employee_Card_Details> cardDetailsList = Collections.singletonList(new Employee_Card_Details());

        when(employeeRepository.findByEmpid(empid)).thenReturn(Optional.of(employee));
        when(modelMapper.map(any(), eq(EmployeeCardDetailsDto.class))).thenReturn(cardDetailsDto);
        when(modelMapper.map(any(), eq(EmployeeRegisterDto.class))).thenReturn(employeeRegisterDto);

		//Employee employee = employeeRepository.findByEmpid(applyLoanDto.getEmployee().getEmpid()).get();
        
        // Call the method
        EmployeeLoanDetailsDto result = employeeCardDetailsService.getLoansByEmployeeId(empid);

        // Verify the result
        assertNotNull(result);
        assertEquals(employee.getId(), result.getEmployee().getId());
        assertEquals(1, result.getEmployeeCardDetailsDto().size());
        assertEquals(cardDetailsDto.getCard_id(), result.getEmployeeCardDetailsDto().get(0).getCard_id());

        // Verify that the repository and mapper methods were called
        verify(employeeRepository).findByEmpid(empid);
        verify(modelMapper).map(any(), eq(EmployeeCardDetailsDto.class));
        verify(employeeRepository).findByEmpid(empid);
    }

//    @Test
//    public void testApplyLoan() {
//        // Mocking data
//        ApplyLoanDto applyLoanDto = new ApplyLoanDto();
//        EmployeeRegisterDto employeeRegisterDto=new EmployeeRegisterDto();
//        employeeRegisterDto.setId(1L);
//        employeeRegisterDto.setBirthdate(new Date(2023,9, 25));
//        employeeRegisterDto.setDepartment("CTO");
//        employeeRegisterDto.setDesignation("CTO");
//        employeeRegisterDto.setEmpid(2151587L);
//        employeeRegisterDto.setGender("Male");
//        employeeRegisterDto.setName("Nilay");
//        employeeRegisterDto.setJoiningdate(new Date(2023,9,25));
//        applyLoanDto.setEmployee(employeeRegisterDto);
//        Loan loan = new Loan();
//        loan.setDuration(1);
//        loan.setLoan_id(1L);
//        loan.setLoan_type("furniture");
//    
//        
//        applyLoanDto.setLoan(loan);
//        ItemDto item=new ItemDto();
//        item.setCategory("furniture");
//        item.setDescription("chair");
//        item.setItemid(1L);
//        item.setMake("wooden");
//        item.setStatus("Yes");
//        item.setValue("100");
//        applyLoanDto.setItem(item);
//
//        Employee employee = new Employee();
//        employee.setId(1L);
//
//        EmployeeCardDetailsDto cardDetailsDto = new EmployeeCardDetailsDto();
//
//        when(employeeRepository.findByEmpid(any())).thenReturn(Optional.of(employee));
//        when(modelMapper.map(any(Loan.class), eq(LoanDto.class))).thenReturn(new LoanDto());
//        when(modelMapper.map(any(Employee.class), eq(EmployeeRegisterDto.class))).thenReturn(employeeRegisterDto);
////        when(modelMapper.map(any(EmployeeCardDetailsDto.class), eq(Employee_Card_Details.class))).thenReturn(new Employee_Card_Details());
////        when(modelMapper.map(any(EmployeeRegisterDto.class), eq(Employee.class))).thenReturn(employee);
////
//
//        // Call the method
//        employeeCardDetailsService.applyLoan(applyLoanDto);
//
//        // Verify that the repository and mapper methods were called
//        verify(employeeRepository).findByEmpid(any());
//        verify(modelMapper).map(any(), eq(EmployeeCardDetailsDto.class));
//        verify(employeeCardDetailsRepository).save(any());
//    }

    @Test
    public void testSetLoanStatus() {
        // Mocking data
        Long loanId = 1L;
        String status = "Approved";

        Employee_Card_Details cardDetails = new Employee_Card_Details();

        when(employeeCardDetailsRepository.findByLoanLoan_id(loanId)).thenReturn(cardDetails);

        // Call the method
        employeeCardDetailsService.setLoanStatus(loanId, status);

        // Verify that the repository method was called
        verify(employeeCardDetailsRepository).findByLoanLoan_id(loanId);
        verify(employeeCardDetailsRepository).save(cardDetails);
    }
}
