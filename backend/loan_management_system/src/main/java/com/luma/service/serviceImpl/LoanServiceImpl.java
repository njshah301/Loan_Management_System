package com.luma.service.serviceImpl;
import java.util.List;

import com.luma.model.Loan;
import com.luma.repository.LoanRepository;
import com.luma.service.service.LoanService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoanServiceImpl implements LoanService {
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

	@Autowired
	private LoanRepository loanRepository;
	
	@Override
	public Loan addLoan(Loan loan) {
		logger.info("LoanServiceImpl: Entered inside addLoan() method");
		return loanRepository.save(loan);
	}

	@Override
	public List<Loan> getAll() {
		logger.info("LoanServiceImpl: Entered inside getAll() method");
		return loanRepository.findAll();
	}
	
	@Override
	public Loan editLoan(Loan loan,Long loan_id) {
		logger.info("LoanServiceImpl: Entered inside editLoan() method");
	    return loanRepository.findById(loan_id)
	  	      .map(record -> {
	  	    	record.setLoan_type(loan.getLoan_type());
	  	    	record.setDuration(loan.getDuration());
	  	        return loanRepository.save(record);
	  	      })
	  	      .orElseGet(() -> {
	  	        loan.setLoan_id(loan.getLoan_id());
	    	      loan.setLoan_type(loan.getLoan_type());
		  	      loan.setDuration(loan.getDuration());
	  	        return loanRepository.save(loan);
	  	      });
	}
	
	@Override
	public Loan deleteLoan (Long loan_id) {
		logger.warn("LoanServiceImpl: Entered inside deleteLoan() method");
		Loan loan = loanRepository.findById(loan_id).get();
		loanRepository.deleteById(loan_id);
		return loan;
	}
	
	@Override
	public Loan getLoanById(Long loan_id) {
		logger.info("LoanServiceImpl: Entered inside getLoanById() method");
		Loan loan=loanRepository.findById(loan_id).get();
		return loan;
	}
}