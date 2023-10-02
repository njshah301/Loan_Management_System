package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class EmployeeCardDetailsTest {

    private Employee_Card_Details cardDetails;

    @BeforeEach
    public void setUp() {
        cardDetails = new Employee_Card_Details();
    }

    @Test
    public void testValidCardDetails() {
        Employee employee = mock(Employee.class);
        Loan loan = mock(Loan.class);

        cardDetails.setEmployee(employee);
        cardDetails.setLoan(loan);
        cardDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        cardDetails.setStatus("Active");

        assertTrue(isValidCardDetails(cardDetails));
    }

    @Test
    public void testNullEmployee() {
        Loan loan = mock(Loan.class);

        cardDetails.setLoan(loan);
        cardDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        cardDetails.setStatus("Active");

        assertFalse(isValidCardDetails(cardDetails));
    }

    @Test
    public void testNullLoan() {
        Employee employee = mock(Employee.class);

        cardDetails.setEmployee(employee);
        cardDetails.setIssueDate(Date.valueOf(LocalDate.now()));
        cardDetails.setStatus("Active");

        assertFalse(isValidCardDetails(cardDetails));
    }

    @Test
    public void testNullIssueDate() {
        Employee employee = mock(Employee.class);
        Loan loan = mock(Loan.class);

        cardDetails.setEmployee(employee);
        cardDetails.setLoan(loan);
        cardDetails.setStatus("Active");

        assertFalse(isValidCardDetails(cardDetails));
    }

    @Test
    public void testNullStatus() {
        Employee employee = mock(Employee.class);
        Loan loan = mock(Loan.class);

        cardDetails.setEmployee(employee);
        cardDetails.setLoan(loan);
        cardDetails.setIssueDate(Date.valueOf(LocalDate.now()));

        assertFalse(isValidCardDetails(cardDetails));
    }

    private boolean isValidCardDetails(Employee_Card_Details cardDetails) {
        return cardDetails.getEmployee() != null
            && cardDetails.getLoan() != null
            && cardDetails.getIssueDate() != null
            && cardDetails.getStatus() != null;
    }
}

