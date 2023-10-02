package com.luma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class DuplicateEntryExistException extends RuntimeException{

	private HttpStatus status;
	private String message;

	
	
	
	public DuplicateEntryExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryExistException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
