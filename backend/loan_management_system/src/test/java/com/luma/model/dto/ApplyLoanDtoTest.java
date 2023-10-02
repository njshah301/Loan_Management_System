package com.luma.model.dto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luma.model.Loan;
import com.luma.model.dto.ApplyLoanDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.ItemDto;

public class ApplyLoanDtoTest {

    private ApplyLoanDto applyLoanDto;

    @BeforeEach
    public void setUp() {
        applyLoanDto = new ApplyLoanDto();
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        EmployeeRegisterDto employee = new EmployeeRegisterDto();
        applyLoanDto.setEmployee(employee);
        assertEquals(employee, applyLoanDto.getEmployee());
    }

    @Test
    public void testItemGetterAndSetter() {
        ItemDto item = new ItemDto();
        applyLoanDto.setItem(item);
        assertEquals(item, applyLoanDto.getItem());
    }

    @Test
    public void testLoanGetterAndSetter() {
        Loan loan = new Loan();
        applyLoanDto.setLoan(loan);
        assertEquals(loan, applyLoanDto.getLoan());
    }

    @Test
    public void testToString() {
        // You can customize this test based on your expected toString() format
        String expectedToString = "ApplyLoanDto(employee=null, item=null, loan=null)";
        assertEquals(expectedToString, applyLoanDto.toString());
    }
}
