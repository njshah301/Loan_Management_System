package com.luma.model.dto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luma.model.dto.EmployeeCardDetailsDto;
import com.luma.model.dto.EmployeeLoanDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLoanDetailsDtoTest {

    private EmployeeLoanDetailsDto employeeLoanDetailsDto;

    @BeforeEach
    public void setUp() {
        employeeLoanDetailsDto = new EmployeeLoanDetailsDto();
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        EmployeeRegisterDto employee = new EmployeeRegisterDto();
        employeeLoanDetailsDto.setEmployee(employee);
        assertEquals(employee, employeeLoanDetailsDto.getEmployee());
    }

    @Test
    public void testEmployeeCardDetailsDtoGetterAndSetter() {
        List<EmployeeCardDetailsDto> cardDetailsList = new ArrayList<>();
        EmployeeCardDetailsDto cardDetails1 = new EmployeeCardDetailsDto();
        EmployeeCardDetailsDto cardDetails2 = new EmployeeCardDetailsDto();
        cardDetailsList.add(cardDetails1);
        cardDetailsList.add(cardDetails2);

        employeeLoanDetailsDto.setEmployeeCardDetailsDto(cardDetailsList);
        assertEquals(cardDetailsList, employeeLoanDetailsDto.getEmployeeCardDetailsDto());
    }
}
