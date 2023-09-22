package com.luma.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee_Card_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long card_id;
	
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="loan_id")
	private Loan loan;
	
	@Column(nullable=false)
	private Date issueDate;
	
	private String status;
}
