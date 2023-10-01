package com.luma.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.luma.model.Loan;
import com.luma.model.dto.LoanDto;
import com.luma.repository.LoanRepository;
import com.luma.service.serviceImpl.LoanServiceImpl;

public class LoanServiceImplTest {

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private LoanServiceImpl loanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddLoan() {
        // Create a loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);

        // Mock the behavior of the loan repository
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        // Call the service method
        Loan result = loanService.addLoan(loan);

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getLoan_id());

        // Verify that the repository method was called
        verify(loanRepository).save(any(Loan.class));
    }

    @Test
    public void testGetAll() {
        // Create a list of loans
        List<Loan> loanList = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setLoan_id(1L);
        Loan loan2 = new Loan();
        loan2.setLoan_id(2L);
        loanList.add(loan1);
        loanList.add(loan2);

        // Mock the behavior of the loan repository
        when(loanRepository.findAll()).thenReturn(loanList);

        // Call the service method
        List<Loan> result = loanService.getAll();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getLoan_id());
        assertEquals(2L, result.get(1).getLoan_id());

        // Verify that the repository method was called
        verify(loanRepository).findAll();
    }

    @Test
    public void testEditLoan() {
        // Create a loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);
        loan.setLoan_type("Personal");
        loan.setDuration(36);

        // Mock the behavior of the loan repository
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        // Call the service method
        Loan editedLoan = new Loan();
        editedLoan.setLoan_id(1L);
        editedLoan.setLoan_type("Home");
        editedLoan.setDuration(48);
        Loan result = loanService.editLoan(editedLoan, 1L);

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getLoan_id());
        assertEquals("Home", result.getLoan_type());
        assertEquals(48, result.getDuration());

        // Verify that the repository methods were called
        verify(loanRepository).findById(1L);
        verify(loanRepository).save(any(Loan.class));
    }

    @Test
    public void testDeleteLoan() {
        // Create a loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);

        // Mock the behavior of the loan repository
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        // Call the service method
        Loan deletedLoan = loanService.deleteLoan(1L);

        // Verify the result
        assertNotNull(deletedLoan);
        assertEquals(1L, deletedLoan.getLoan_id());

        // Verify that the repository methods were called
        verify(loanRepository).findById(1L);
        verify(loanRepository).deleteById(1L);
    }

    @Test
    public void testGetLoanById() {
        // Create a loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);

        // Mock the behavior of the loan repository
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        // Call the service method
        Loan result = loanService.getLoanById(1L);

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getLoan_id());

        // Verify that the repository method was called
        verify(loanRepository).findById(1L);
    }

    @Test
    public void testGetLoansByCategory() {
        // Create a loan
        Loan loan = new Loan();
        loan.setLoan_id(1L);
        loan.setLoan_type("furniure");

        // Mock the behavior of the loan repository
        when(loanRepository.findByLoanLoan_type("furniture")).thenReturn(loan);

        // Mock the behavior of the modelMapper
        when(modelMapper.map(loan, LoanDto.class)).thenReturn(new LoanDto());

        // Call the service method
        LoanDto result = loanService.getLoansByCategory("furniture");

        // Verify the result
        assertNotNull(result);

        // Verify that the repository method was called
        verify(loanRepository).findByLoanLoan_type("furniture");
    }
}
