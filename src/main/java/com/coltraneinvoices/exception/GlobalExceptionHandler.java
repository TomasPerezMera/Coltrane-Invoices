package com.coltraneinvoices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coltraneinvoices.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        ErrorResponse error = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(error);
	    }
	    
	    // TODO Individual Exceptions List:
		//	    DuplicateResourceException
		//	    InvalidOperationException
		//	    PaymentFailedException
		//	    InsufficientStockException
	}