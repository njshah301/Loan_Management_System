package com.luma.model.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoanDtoTest {

    @Test
    public void testLoanDto() {
        // Create an instance of LoanDto
        LoanDto loanDto = new LoanDto();

        // Set values for the fields
        loanDto.setLoan_id(1L);
        loanDto.setLoan_type("Sample Loan Type");
        loanDto.setDuration(12);

        // Verify the values
        assertEquals(1L, loanDto.getLoan_id());
        assertEquals("Sample Loan Type", loanDto.getLoan_type());
        assertEquals(12, loanDto.getDuration());
    }

    @Test
    public void testLoanDtoWithNegativeDuration() {
        // Create an instance of LoanDto with a negative duration
        LoanDto loanDto = new LoanDto();

        // Set values for the fields, including a negative duration
        loanDto.setLoan_id(2L);
        loanDto.setLoan_type("Another Loan Type");
        loanDto.setDuration(-6);

        // Verify the values
        assertEquals(2L, loanDto.getLoan_id());
        assertEquals("Another Loan Type", loanDto.getLoan_type());
        assertEquals(-6, loanDto.getDuration());
    }

    @Test
    public void testLoanDtoWithNullValues() {
        // Create an instance of LoanDto with null values
        LoanDto loanDto = new LoanDto();

        // Verify that all fields are initially null
        assertNull(loanDto.getLoan_id());
        assertNull(loanDto.getLoan_type());
        assertEquals(0, loanDto.getDuration()); // Duration should default to 0 for int
    }
}
