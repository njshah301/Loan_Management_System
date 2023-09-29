package com.luma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

public class BadUsernameOrPasswordException extends RuntimeException {

	
	private HttpStatus status;
	private String message;

	
	
	
	public BadUsernameOrPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BadUsernameOrPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BadUsernameOrPasswordException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
}
