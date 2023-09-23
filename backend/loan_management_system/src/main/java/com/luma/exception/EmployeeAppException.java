package org.reni.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class EmployeeAppException extends RuntimeException {
	
	private HttpStatus status;
	private String message;

	
	
	
	public EmployeeAppException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeAppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmployeeAppException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
