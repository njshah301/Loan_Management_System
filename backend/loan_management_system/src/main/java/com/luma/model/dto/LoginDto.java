package com.luma.model.dto;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class LoginDto {
	@Column(nullable = false)
	private String usernameOrEmail;

	@Column(nullable = false)
	private String password;
}
