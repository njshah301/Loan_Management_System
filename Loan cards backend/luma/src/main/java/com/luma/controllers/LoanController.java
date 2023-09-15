package com.luma.controllers;
import java.util.List;
import com.luma.entities.Loan;
import com.luma.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luma.repositories.LoanRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/loans")
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	@PostMapping
	public ResponseEntity<Loan> addLoan(@Valid  @RequestBody Loan loan){
		Loan l=loanService.addLoan(loan);
		return new ResponseEntity<Loan>(l,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Loan> getAllLoans(){
		return loanService.getAll();
	}
	
	@GetMapping("/{loan_id}")
	public Loan getLoanById( @PathVariable Long loan_id){
		return loanService.getLoanById(loan_id);
	}
	
	@PutMapping("/{loan_id}")
	public ResponseEntity<Loan> editLoan(@Valid  @RequestBody Loan loan, @PathVariable Long loan_id){
		Loan l=loanService.editLoan(loan,loan_id);
		return new ResponseEntity<Loan>(l,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{loan_id}")
	public ResponseEntity<Loan> deleteLoan(@PathVariable Long loan_id){
		Loan l=loanService.deleteLoan(loan_id);
		return new ResponseEntity<Loan>(l,HttpStatus.OK);
	}
}