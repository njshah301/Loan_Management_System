package com.luma.model.dto;

import java.sql.Date;

import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
//
import lombok.Data;

@Data


public class EmployeeDto {
	
	private Long id;
	
	@NotNull(message="Enter Employee ID")
	private Long empId;

	@NotBlank(message="Name must not be NULL")
	private String name;

	@NotBlank(message="Designation must not be NULL")
	private String designation;

	@NotBlank(message="Department must not be NULL")
	private String department;

	@NotBlank(message="Please choose gender")
	@Pattern(regexp = "(Male|Female|Other)")

	private String gender;

	@NotBlank(message="Please choose your birthdate")
	private Date birthdate;

	@NotBlank(message="Please choose your joinig date")
	private Date joiningdate;
	
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

}