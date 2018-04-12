package com.nav.add.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nav.add.error.ErrorMessage;
import com.nav.add.exception.ValidationException;


@ControllerAdvice
class ExceptionHandlerAdvice {
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorMessage> validationExceptionHandler(Exception e) {
		ErrorMessage error = new ErrorMessage("Validation Failed", e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}