package com.educore.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.educore.school.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(
	        ResourceNotFoundException ex) {

	    ApiResponse<Void> response = new ApiResponse<>();

	    response.setSuccess(false);
	    response.setMessage(ex.getMessage());

	    return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body(response);
	}

}
