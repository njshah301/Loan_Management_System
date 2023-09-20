package com.luma.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Loans")
public class Loan {
	@Id
	private Long loan_id;
	@Column(nullable =false)
	@Pattern(regexp = "(furniture|stationary|crockery)",message = "Loan type should be either furniture, stationary or crockery")
	private String loan_type;
	@Max(value = 10,message = "Loan Duration cannot be less than 1 year and more than 10 years")
	@Min(value = 1,message = "Loan Duration cannot be less than 1 year and more than 10 years")
	private int duration;
}