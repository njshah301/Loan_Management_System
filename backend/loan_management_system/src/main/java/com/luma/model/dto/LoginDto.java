package com.luma.model.dto;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class LoginDto {
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public LoginDto() {
		// TODO Auto-generated constructor stub
	}

	@Column(nullable = false)
	private String usernameOrEmail;

	@Column(nullable = false)
	private String password;
}
