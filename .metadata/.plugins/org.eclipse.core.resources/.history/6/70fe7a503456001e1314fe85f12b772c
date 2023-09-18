package com.luma.model;

import java.awt.print.Printable;
import java.sql.Date;

import org.springframework.boot.autoconfigure.liquibase.DataSourceClosingSpringLiquibase;
import org.springframework.dao.DataAccessResourceFailureException;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique=true)
	private Long empid;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String designation;

	@Column(nullable = false)
	private String department;

	@Pattern(regexp = "(Male|Female|Other)")
	private String gender;

	@Column(nullable = false)
	private Date birthdate;

	@Column(nullable = false)
	private Date joiningdate;
	
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
	
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private java.util.List<Employee_Issue_Details> employee_Issue_Details;
	
	
	
}
