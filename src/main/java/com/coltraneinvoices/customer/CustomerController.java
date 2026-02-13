package com.coltraneinvoices.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coltraneinvoices.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// Métodos planos ya que manejamos Excepciones de forma global:
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
	
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO dto) {
        Customer createdCustomer = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    	@PutMapping("/{id}")
    	public Customer updateCustomerById(@PathVariable Long id, @RequestBody CustomerDTO dto) {
    		return customerService.updateCustomer(id, dto);
    	}
    
    @DeleteMapping("/{id}")
    	public void deleteCustomerById(@PathVariable Long id) {
    		customerService.deleteCustomerById(id);
    }
    
}