package com.coltraneinvoices.exception;

@SuppressWarnings("serial")
public class InsufficientStockException extends RuntimeException {
	
	public InsufficientStockException(String productName) {
		super("Lo sentimos! No hay stock disponible para el ítem " + productName + ". Elegí otro ítem!");
	}
}