package com.luma.service;
import java.util.List;

import com.luma.entities.Loan;
public interface LoanService {
	Loan addLoan(Loan loan);
	List<Loan> getAll();
	Loan editLoan(Loan loan,Long loan_id);
	Loan deleteLoan(Long loan_id);
	Loan getLoanById(Long loan_id);
}
