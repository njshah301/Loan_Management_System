package com.luma.model.dto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luma.model.dto.EmployeeIssueDetailsDto;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.ItemDto;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeIssueDetailsDtoTest {

    private EmployeeIssueDetailsDto employeeIssueDetailsDto;

    @BeforeEach
    public void setUp() {
        employeeIssueDetailsDto = new EmployeeIssueDetailsDto();
    }

    @Test
    public void testIssueIdGetterAndSetter() {
        Long issueId = 1L;
        employeeIssueDetailsDto.setIssue_id(issueId);
        assertEquals(issueId, employeeIssueDetailsDto.getIssue_id());
    }

    @Test
    public void testEmployeeGetterAndSetter() {
        EmployeeRegisterDto employee = new EmployeeRegisterDto();
        employeeIssueDetailsDto.setEmployee(employee);
        assertEquals(employee, employeeIssueDetailsDto.getEmployee());
    }

    @Test
    public void testItemGetterAndSetter() {
        ItemDto item = new ItemDto();
        employeeIssueDetailsDto.setItem(item);
        assertEquals(item, employeeIssueDetailsDto.getItem());
    }

    @Test
    public void testIssueDateGetterAndSetter() {
        Date issueDate = new Date();
        employeeIssueDetailsDto.setIssueDate(issueDate);
        assertEquals(issueDate, employeeIssueDetailsDto.getIssueDate());
    }

    @Test
    public void testReturnDateGetterAndSetter() {
        LocalDate returnDate = LocalDate.now();
        employeeIssueDetailsDto.setReturn_date(returnDate);
        assertEquals(returnDate, employeeIssueDetailsDto.getReturn_date());
    }
}
