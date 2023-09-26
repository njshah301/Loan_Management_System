package com.luma.model.dto;

import com.luma.model.Loan;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class ChangeCredentialDto {
	@NotNull(message="Enter Password")
	private String password;
}
