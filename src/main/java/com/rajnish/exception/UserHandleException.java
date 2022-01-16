package com.rajnish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserHandleException {

	@ExceptionHandler(value=UserErrorException.class)
	public ResponseEntity<UserError> handleException() {
		UserError error=new UserError();
		error.setErrorCode("1001");
		error.setErrorMessage("Hey buddy");
		ResponseEntity<UserError> erro=new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		return erro;
		
	}
}
