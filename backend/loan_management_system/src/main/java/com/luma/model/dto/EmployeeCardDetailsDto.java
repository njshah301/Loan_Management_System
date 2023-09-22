package com.luma.model.dto;

import java.time.LocalDate;
import java.util.Date;

import com.luma.model.Employee;
import com.luma.model.Item;
import com.luma.model.Loan;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EmployeeCardDetailsDto {
	private Long card_id;
	

	private EmployeeRegisterDto employee;
	
	private LoanDto loan;
	@Column(nullable=false)
	private Date issueDate;
	
	private String status;
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Long getCard_id() {
		return card_id;
	}
	public void setCard_id(Long card_id) {
		this.card_id = card_id;
	}
	public EmployeeRegisterDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeRegisterDto employee) {
		this.employee = employee;
	}
	public LoanDto getLoan() {
		return loan;
	}
	public void setLoan(LoanDto loan) {
		this.loan = loan;
	}
	
}
