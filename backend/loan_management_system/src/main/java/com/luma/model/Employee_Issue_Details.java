package com.luma.model;

import java.awt.print.Printable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

public class Employee_Issue_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issue_id;
	
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="itemid")
	private Item item;
	
	@Column(nullable=false)
	private Date issueDate;
	
	@Column(nullable=false)
	private LocalDate return_date;
}