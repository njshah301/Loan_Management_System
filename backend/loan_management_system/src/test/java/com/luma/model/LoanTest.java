package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanTest {

    private Loan loan;

    @BeforeEach
    public void setUp() {
        loan = new Loan();
    }

    @Test
    public void testValidLoan() {
        loan.setLoan_type("furniture");
        loan.setDuration(5);

        assertTrue(isValidLoan(loan));
    }

    @Test
    public void testInvalidLoanType() {
        loan.setLoan_type("electronics"); // Invalid loan type

        assertFalse(isValidLoan(loan));
    }

    @Test
    public void testInvalidLoanDuration() {
        loan.setLoan_type("stationary");
        loan.setDuration(11); // Invalid duration

        assertFalse(isValidLoan(loan));
    }

    private boolean isValidLoan(Loan loan) {
        boolean validLoanType = loan.getLoan_type() != null && loan.getLoan_type().matches("(furniture|stationary|crockery)");
        boolean validLoanDuration = loan.getDuration() >= 1 && loan.getDuration() <= 10;

        return validLoanType && validLoanDuration;
    }

    @Test
    public void testNullLoanType() {
        // Loan type is null
        loan.setDuration(7);

        assertFalse(isValidLoan(loan));
    }

    @Test
    public void testNegativeLoanDuration() {
        // Negative loan duration
        loan.setLoan_type("crockery");
        loan.setDuration(-2);

        assertFalse(isValidLoan(loan));
    }

    @Test
    public void testZeroLoanDuration() {
        // Zero loan duration
        loan.setLoan_type("furniture");
        loan.setDuration(0);

        assertFalse(isValidLoan(loan));
    }

    @Test
    public void testMaxLoanDuration() {
        // Maximum valid loan duration
        loan.setLoan_type("stationary");
        loan.setDuration(10);

        assertTrue(isValidLoan(loan));
    }
}
