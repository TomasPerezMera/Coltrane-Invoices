package com.coltraneinvoices.customer;

import com.coltraneinvoices.dto.CustomerDTO;
import com.coltraneinvoices.service.TimeProvider;

public class CustomerService {

	private final CustomerRepository customerRepository;
	private final TimeProvider timeProvider;
	
	public CustomerService(CustomerRepository customerRepository, TimeProvider timeProvider) {
	this.customerRepository = customerRepository;
	this.timeProvider = timeProvider;
	}
	
	public Customer createCustomer(CustomerDTO dto) {
		
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