package com.luma.repositories;

import com.luma.entities.Loan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface LoanRepository extends JpaRepository<Loan, Long>{
	Optional<Loan> findById(Long loan_id);
}
