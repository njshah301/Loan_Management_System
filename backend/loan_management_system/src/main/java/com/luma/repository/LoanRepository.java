package com.luma.repository;

import com.luma.model.Loan;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface LoanRepository extends JpaRepository<Loan, Long>{
	Optional<Loan> findById(Long loan_id);

	@Query("SELECT u FROM Loan u WHERE u.loan_type = ?1")
	Loan findByLoanLoan_type(String category);

}