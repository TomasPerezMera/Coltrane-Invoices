package com.coltraneinvoices.customer;

import com.coltraneinvoices.dto.CustomerDTO;
import com.coltraneinvoices.exception.DuplicateResourceException;
import com.coltraneinvoices.service.TimeProvider;

public class CustomerService {

	private final CustomerRepository customerRepository;
	private final TimeProvider timeProvider;
	
	public CustomerService(CustomerRepository customerRepository, TimeProvider timeProvider) {
	this.customerRepository = customerRepository;
	this.timeProvider = timeProvider;
	}
	
	public Customer createCustomer(CustomerDTO dto) {
		
		if(customerRepository.existsByDni(dto.getDni())) {
		    throw new DuplicateResourceException("Ya existe un cliente con este DNI!");
		}
		
		Customer customer = Customer.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.dni(dto.getDni())
				.email(dto.getEmail())
				.createdAt(timeProvider.getCurrentUtcTime())
				.build();

	    return customerRepository.save(customer);
	}

	
}