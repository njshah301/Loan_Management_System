package com.luma.service.serviceImpl;
import java.util.List;

import com.luma.model.Loan;
import com.luma.repository.LoanRepository;
import com.luma.service.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanRepository loanRepository;
	
	@Override
	public Loan addLoan(Loan loan) {
		// TODO Auto-generated method stub
		return loanRepository.save(loan);
	}

	@Override
	public List<Loan> getAll() {
		// TODO Auto-generated method stub
		return loanRepository.findAll();
	}
	
	@Override
	public Loan editLoan(Loan loan,Long loan_id) {
	    
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
		Loan loan = loanRepository.findById(loan_id).get();
		loanRepository.deleteById(loan_id);
		return loan;
	}
	
	@Override
	public Loan getLoanById(Long loan_id) {
		// TODO Auto-generated method stub
		Loan loan=loanRepository.findById(loan_id).get();
		return loan;
	}
}