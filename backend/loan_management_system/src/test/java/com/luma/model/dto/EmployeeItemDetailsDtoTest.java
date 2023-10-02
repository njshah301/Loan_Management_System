package com.luma.model.dto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luma.model.dto.EmployeeItemDetailsDto;
import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeItemDetailsDtoTest {

    private EmployeeItemDetailsDto employeeItemDetailsDto;

    @BeforeEach
    public void setUp() {
        employeeItemDetailsDto = new EmployeeItemDetailsDto();
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        EmployeeRegisterDto employee = new EmployeeRegisterDto();
        employeeItemDetailsDto.setEmployee(employee);
        assertEquals(employee, employeeItemDetailsDto.getEmployee());
    }

    @Test
    public void testEmployeeIssueDetailsDtoGetterAndSetter() {
        List<EmployeeIssueDetailsDto> issueDetailsList = new ArrayList<>();
        EmployeeIssueDetailsDto issueDetails1 = new EmployeeIssueDetailsDto();
        EmployeeIssueDetailsDto issueDetails2 = new EmployeeIssueDetailsDto();
        issueDetailsList.add(issueDetails1);
        issueDetailsList.add(issueDetails2);

        employeeItemDetailsDto.setEmployeeIssueDetailsDto(issueDetailsList);
        assertEquals(issueDetailsList, employeeItemDetailsDto.getEmployeeIssueDetailsDto());
    }
}
