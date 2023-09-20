package com.luma.model.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;




@Data
public class EmployeeRegisterDto {
	
	private Long id;
	
	@NotNull(message="Enter Employee ID")
	private Long empid;
	@NotBlank(message="Name must not be NULL")
	private String name;

	@NotBlank(message="Designation must not be NULL")
	private String designation;

	@NotBlank(message="Department must not be NULL")
	private String department;

	@NotBlank(message="Please choose gender")
	@Pattern(regexp = "(Male|Female|Other)")

	private String gender;

	@NotNull(message="Please choose your birthdate")
	private Date birthdate;

	@NotNull(message="Please choose your joinig date")
	private Date joiningdate;
	
	

}
