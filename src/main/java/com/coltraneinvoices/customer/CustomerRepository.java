package com.coltraneinvoices.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(Long id);

	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByLastName(String lastName);
	
	Optional<Customer> findByEmail(String email);
	
	Optional<Customer> findByDni(Long dni);
	
	Optional<Customer> findByPhoneNumber(Long phoneNumber);
	
	boolean existsByDni(Long dni);
	
}