package com.coltraneinvoices.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(Long id);
	
	Optional<Customer> findByDni(Long dni);
	
	Optional<Customer> findByPhoneNumber(Long phoneNumber);
	
	boolean existsByDni(Long dni);
	
	// Métodos para búsqueda con resultados parciales, ignorando upper/lowercase;
	List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Customer> findByLastNameContainingIgnoreCase(String lastName);
	
	List<Customer> findByEmailContainingIgnoreCase(String email);
	
}