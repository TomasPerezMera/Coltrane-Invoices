package com.coltraneinvoices.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Long id) {
        super("Lo sentimos! El " + resource + " con ID [" + id + "] no se encuentra disponible.");
    }
    
    public ResourceNotFoundException(String resource, String searchParam) {
    		super("Lo sentimos! No encontramos resultados de " + resource + " que incluyan: " + searchParam + 
    				". Intentá nuevamente.");
    }
}