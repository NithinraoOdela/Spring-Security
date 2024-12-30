package com.springsecurity.springsecurity.securityException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springsecurity.springsecurity.securityentity.ApplicationResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApplicationResponse> resourseNotFound(ResourceNotFoundException ex) {
		ApplicationResponse app = new ApplicationResponse(ex.getUserName(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(app);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApplicationResponse> exception(Exception ex) {
		ApplicationResponse app = new ApplicationResponse("name", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(app);
	}

}
