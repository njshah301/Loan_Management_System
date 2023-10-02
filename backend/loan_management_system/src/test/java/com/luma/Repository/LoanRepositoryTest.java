package com.luma.Repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.Loan;
import com.luma.repository.LoanRepository;

@SpringBootTest
public class LoanRepositoryTest {

    @Mock
    private LoanRepository loanRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Create a sample loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);

        // Mock the findById method
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        // Call the method you want to test
        Optional<Loan> foundLoan = loanRepository.findById(1L);

        // Assertions
        assertTrue(foundLoan.isPresent());
        assertEquals(1L, foundLoan.get().getLoan_id());

        // Verify that the method was called with the expected argument
        verify(loanRepository).findById(1L);
    }

    @Test
    public void testFindByLoanLoan_type() {
        // Create a sample loan
        Loan loan = new Loan();
        loan.setLoan_type("Home Loan");

        // Mock the findByLoanLoan_type method
        when(loanRepository.findByLoanLoan_type("Home Loan")).thenReturn(loan);

        // Call the method you want to test
        Loan foundLoan = loanRepository.findByLoanLoan_type("Home Loan");

        // Assertions
        assertNotNull(foundLoan);
        assertEquals("Home Loan", foundLoan.getLoan_type());

        // Verify that the method was called with the expected argument
        verify(loanRepository).findByLoanLoan_type("Home Loan");
    }
}
