package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class EmployeeIssueDetailsTest {

    private Employee_Issue_Details issueDetails;

    @BeforeEach
    public void setUp() {
        issueDetails = new Employee_Issue_Details();
    }

    @Test
    public void testValidIssueDetails() {
        Employee employee = mock(Employee.class);
        Item item = mock(Item.class);

        issueDetails.setEmployee(employee);
        issueDetails.setItem(item);
        issueDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        issueDetails.setReturn_date(LocalDate.now().plusDays(7));

        assertTrue(isValidIssueDetails(issueDetails));
    }

    @Test
    public void testNullEmployee() {
        Item item = mock(Item.class);

        issueDetails.setItem(item);
        issueDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        issueDetails.setReturn_date(LocalDate.now().plusDays(7));

        assertFalse(isValidIssueDetails(issueDetails));
    }

    @Test
    public void testNullItem() {
        Employee employee = mock(Employee.class);

        issueDetails.setEmployee(employee);
        issueDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        issueDetails.setReturn_date(LocalDate.now().plusDays(7));

        assertFalse(isValidIssueDetails(issueDetails));
    }

    @Test
    public void testNullIssueDate() {
        Employee employee = mock(Employee.class);
        Item item = mock(Item.class);

        issueDetails.setEmployee(employee);
        issueDetails.setItem(item);
        issueDetails.setReturn_date(LocalDate.now().plusDays(7));

        assertFalse(isValidIssueDetails(issueDetails));
    }

    @Test
    public void testNullReturnDate() {
        Employee employee = mock(Employee.class);
        Item item = mock(Item.class);

        issueDetails.setEmployee(employee);
        issueDetails.setItem(item);
        issueDetails.setIssueDate(Date.valueOf(LocalDate.now()));

        assertFalse(isValidIssueDetails(issueDetails));
    }

    private boolean isValidIssueDetails(Employee_Issue_Details issueDetails) {
        return issueDetails.getEmployee() != null
            && issueDetails.getItem() != null
            && issueDetails.getIssueDate() != null
            && issueDetails.getReturn_date() != null;
    }
}

