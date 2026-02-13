package com.coltraneinvoices.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomer_FirstName(String firstName);
	
	Customer findByCustomer_LastName(String lastName);
	
	Customer findByCustomer_Email(String email);
	
	boolean existsByDni(Long dni);
	
}