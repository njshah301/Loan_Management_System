package com.luma.Repository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.Employee_Card_Details;
import com.luma.repository.EmployeeCardDetailsRepository;

@SpringBootTest
public class EmployeeCardsDetatilsRepositoryTest {

    @Mock
    private EmployeeCardDetailsRepository employeeCardDetailsRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByLoanLoanId() {
        // Create a sample Employee_Card_Details
        Employee_Card_Details cardDetails = new Employee_Card_Details();
        cardDetails.setCard_id(1L);

        // Mock the findByLoanLoanId method
        when(employeeCardDetailsRepository.findByLoanLoan_id(1L)).thenReturn(cardDetails);

        // Call the method you want to test
        Employee_Card_Details foundCardDetails = employeeCardDetailsRepository.findByLoanLoan_id(1L);

        // Assertions
        assertNotNull(foundCardDetails);
        assertEquals(1L, foundCardDetails.getCard_id());

        // Verify that the method was called with the expected argument
        verify(employeeCardDetailsRepository).findByLoanLoan_id(1L);
    }
}