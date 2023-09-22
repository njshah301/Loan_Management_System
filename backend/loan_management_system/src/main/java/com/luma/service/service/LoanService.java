package com.luma.service.service;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.luma.model.Loan;
import com.luma.model.dto.LoanDto;
public interface LoanService {
	Loan addLoan(Loan loan);
	List<Loan> getAll();
	Loan editLoan(Loan loan,Long loan_id);
	Loan deleteLoan(Long loan_id);
	Loan getLoanById(Long loan_id);
	LoanDto getLoansByCategory(String category);
}