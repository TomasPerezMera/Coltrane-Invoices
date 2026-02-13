package com.coltraneinvoices.exception;

@SuppressWarnings("serial")
public class PaymentFailedException extends RuntimeException {
	
	public PaymentFailedException(String message) {
		super(message);
	}
}