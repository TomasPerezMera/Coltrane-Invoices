package com.coltraneinvoices.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerId(Long id);

	Customer findByFirstName(String firstName);
	
	Customer findByLastName(String lastName);
	
	Customer findByEmail(String email);
	
	Customer findByDni(Long dni);
	
	boolean existsByDni(Long dni);
	
}