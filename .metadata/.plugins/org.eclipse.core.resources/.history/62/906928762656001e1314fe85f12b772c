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
public class EmployeeIssueDetailsDto {	
	
	private Long issue_id;
	

	private EmployeeRegisterDto employee;
	
	private ItemDto item;
	private Loan loan;
	@Column(nullable=false)
	private Date issueDate;
	
	@Column(nullable=false)
	private LocalDate return_date;
}
