package com.luma.exception;

import org.springframework.http.HttpStatus;

public class ForiegnKeyException extends RuntimeException{
	private HttpStatus status;
	private String message;

	
	
	
	public ForiegnKeyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForiegnKeyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ForiegnKeyException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
}
