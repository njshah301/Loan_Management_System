package com.luma.controller;
import java.util.List;
import com.luma.model.Loan;
import com.luma.model.dto.ItemDto;
import com.luma.model.dto.LoanDto;
import com.luma.service.service.LoanService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.luma.repository.LoanRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/loans")
public class LoanController {
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	@Autowired
	private LoanService loanService;
	
	@PostMapping
	public ResponseEntity<Loan> addLoan(@Valid  @RequestBody Loan loan){
		logger.info("LoanController: Entered inside addLoan() method");
		Loan l=loanService.addLoan(loan);
		return new ResponseEntity<Loan>(l,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Loan> getAllLoans(){
		logger.info("LoanController: Entered inside getAllLoans() method");
		return loanService.getAll();
	}
	
	@GetMapping("/{loan_id}")
	public Loan getLoanById( @PathVariable Long loan_id){
		logger.info("LoanController: Entered inside getLoanById() method");
		return loanService.getLoanById(loan_id);
	}
	
	@PutMapping("/{loan_id}")
	public ResponseEntity<Loan> editLoan(@Valid  @RequestBody Loan loan, @PathVariable Long loan_id){
		logger.info("LoanController: Entered inside editLoan() method");
		Loan l=loanService.editLoan(loan,loan_id);
		return new ResponseEntity<Loan>(l,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{loan_id}")
	public ResponseEntity<Loan> deleteLoan(@PathVariable Long loan_id){
		logger.info("LoanController: Entered inside deleteLoan() method");
		Loan l=loanService.deleteLoan(loan_id);
		return new ResponseEntity<Loan>(l,HttpStatus.OK);
	}
	
	@GetMapping(path="/category/{category}")
	public LoanDto getLoansByCategory(@PathVariable String category)
	{ 
		logger.info("ItemController: Entered inside getItemsById() method");
		LoanDto loanDto=loanService.getLoansByCategory(category);
		return loanDto;
	}
}