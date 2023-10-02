package com.luma.model.dto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luma.model.dto.EmployeeCardDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoanDto;

import java.util.Date;

public class EmployeeCardDetailsDtoTest {

    private EmployeeCardDetailsDto employeeCardDetailsDto;

    @BeforeEach
    public void setUp() {
        employeeCardDetailsDto = new EmployeeCardDetailsDto();
    }

    @Test
    public void testCardIdGetterAndSetter() {
        Long cardId = 1L;
        employeeCardDetailsDto.setCard_id(cardId);
        assertEquals(cardId, employeeCardDetailsDto.getCard_id());
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        EmployeeRegisterDto employee = new EmployeeRegisterDto();
        employeeCardDetailsDto.setEmployee(employee);
        assertEquals(employee, employeeCardDetailsDto.getEmployee());
    }

    @Test
    public void testLoanGetterAndSetter() {
        LoanDto loan = new LoanDto();
        employeeCardDetailsDto.setLoan(loan);
        assertEquals(loan, employeeCardDetailsDto.getLoan());
    }

    @Test
    public void testIssueDateGetterAndSetter() {
        Date issueDate = new Date();
        employeeCardDetailsDto.setIssueDate(issueDate);
        assertEquals(issueDate, employeeCardDetailsDto.getIssueDate());
    }

    @Test
    public void testStatusGetterAndSetter() {
        String status = "Active";
        employeeCardDetailsDto.setStatus(status);
        assertEquals(status, employeeCardDetailsDto.getStatus());
    }
}
