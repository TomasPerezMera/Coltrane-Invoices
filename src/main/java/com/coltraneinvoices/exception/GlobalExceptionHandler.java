package com.coltraneinvoices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coltraneinvoices.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
	        ErrorResponse error = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body(error);
	    }
	    
	    @ExceptionHandler(DuplicateResourceException.class)
	    public ResponseEntity<ErrorResponse> handleDuplicateResource(DuplicateResourceException ex) {
	    		ErrorResponse error = new ErrorResponse("DUPLICATE_RESOURCE", ex.getMessage());
	    		return ResponseEntity
	    				.status(HttpStatus.CONFLICT)
	    				.body(error);
	    }
	    
	    @ExceptionHandler(InvalidOperationException.class)
	    public ResponseEntity<ErrorResponse> handleInvalidOperation(InvalidOperationException ex) {
	        ErrorResponse error = new ErrorResponse("INVALID_OPERATION", ex.getMessage());
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(error);
	    }
	    
	    @ExceptionHandler(PaymentFailedException.class)
	    public ResponseEntity<ErrorResponse> handlePaymentFailed(PaymentFailedException ex) {
	    		ErrorResponse error = new ErrorResponse("PAYMENT_FAILED", ex.getMessage());
	    		return ResponseEntity
	    				.status(HttpStatus.BAD_REQUEST)
	    				.body(error);
	    }
	    
	    @ExceptionHandler(InsufficientStockException.class)
	    public ResponseEntity<ErrorResponse> handleInsufficientStock(InsufficientStockException ex) {
	    		ErrorResponse error = new ErrorResponse("INSUFFICIENT_STOCK", ex.getMessage());
    			return ResponseEntity
    					.status(HttpStatus.CONFLICT)
    					.body(error);
	    }
	}