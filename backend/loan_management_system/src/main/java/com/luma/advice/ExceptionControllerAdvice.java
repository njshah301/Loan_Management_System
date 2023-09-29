package com.luma.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luma.exception.BadUsernameOrPasswordException;
import com.luma.exception.ForiegnKeyException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(BadUsernameOrPasswordException.class)
	public ResponseEntity<String> handleBadCredentialException(BadUsernameOrPasswordException badCredentialsException)
	{
		return new ResponseEntity<String> ("Please enter correct username or password.",HttpStatus.UNAUTHORIZED);
	}
	

	@ExceptionHandler(ForiegnKeyException.class)
	public ResponseEntity<String> handleForiegnKeyException(BadUsernameOrPasswordException badCredentialsException)
	{
		return new ResponseEntity<String> ("The entity is referenced to another entity. You cannot delete this data.",HttpStatus.BAD_REQUEST);
	}
}
