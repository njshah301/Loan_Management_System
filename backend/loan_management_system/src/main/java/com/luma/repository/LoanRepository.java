package com.luma.repository;

import com.luma.model.Loan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface LoanRepository extends JpaRepository<Loan, Long>{
	Optional<Loan> findById(Long loan_id);
}