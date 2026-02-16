package com.coltraneinvoices.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coltraneinvoices.dto.CustomerDTO;
import com.coltraneinvoices.exception.DuplicateResourceException;
import com.coltraneinvoices.exception.InvalidOperationException;
import com.coltraneinvoices.exception.ResourceNotFoundException;
import com.coltraneinvoices.service.TimeProvider;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final TimeProvider timeProvider;
	
	public CustomerService(CustomerRepository customerRepository, TimeProvider timeProvider) {
	this.customerRepository = customerRepository;
	this.timeProvider = timeProvider;
	}
	
	@Transactional
	public Customer createCustomer(CustomerDTO dto) {
		
		if(customerRepository.existsByDni(dto.getDni())) {
		    throw new DuplicateResourceException("Ya existe un cliente con este DNI!");
		}
		
		Customer customer = Customer.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.dni(dto.getDni())
				.email(dto.getEmail())
				.address(dto.getAddress())
				.phoneNumber(dto.getPhoneNumber())
				.createdAt(timeProvider.getCurrentUtcTime())
				.build();

	    return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId)
		        .orElseThrow(() -> new ResourceNotFoundException("Cliente", customerId));
	}
	
	// Métodos de búsqueda por Params:
	public List<CustomerDTO> searchByFirstName(String firstName) {
		
		List<Customer> customers = customerRepository.findByFirstName(firstName);
	    if (customers.isEmpty()) {
	        throw new ResourceNotFoundException("Clientes", firstName);
	    }
	    
	    List<CustomerDTO> dtos = new ArrayList<>();
	    for (Customer customer : customers) {
	        dtos.add(convertToDTO(customer));
	    }
	    
	    return dtos;
	}
	
	public List<CustomerDTO> searchByLastName(String lastName) {
		
		List<Customer> customers = customerRepository.findByLastName(lastName);
	    if (customers.isEmpty()) {
	        throw new ResourceNotFoundException("Clientes", lastName);
	    }
	    
	    List<CustomerDTO> dtos = new ArrayList<>();
	    for (Customer customer : customers) {
	        dtos.add(convertToDTO(customer));
	    }
	    
	    return dtos;
	}
	
	public CustomerDTO searchByDni(Long dni) {
	    Customer customer = customerRepository.findByDni(dni)
	        .orElseThrow(() -> new ResourceNotFoundException("Productos", dni));
	    
	    return convertToDTO(customer);
	}
	
	public CustomerDTO searchByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Clientes", email));
		
		return convertToDTO(customer);
	}
	
	public CustomerDTO searchByPhoneNumber(Long phoneNumber) {
		Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Clientes", phoneNumber));
		
		return convertToDTO(customer);
	}
	
	
	public List<CustomerDTO> getAllCustomers() {
	    return customerRepository.findAll().stream()
	        .map(this::convertToDTO)
	        .toList();
	}
	
	@Transactional
	public Customer updateCustomer(Long customerId, CustomerDTO dto) {
		
		Customer customer = customerRepository.findById(customerId)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer", customerId));
		
		if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) {
		    customer.setFirstName(dto.getFirstName());
		}
		if (dto.getLastName() != null && !dto.getLastName().isBlank()) {
		    customer.setLastName(dto.getLastName());
		}
		if (dto.getAddress() != null && !dto.getAddress().isBlank()) {
		    customer.setAddress(dto.getAddress());
		}
		if (dto.getDni() != null && dto.getDni() != 0) {
		    customer.setDni(dto.getDni());
		}
		if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
		    customer.setEmail(dto.getEmail());
		}
		if (dto.getPhoneNumber() != null && dto.getPhoneNumber() != 0L) {
		    customer.setPhoneNumber(dto.getPhoneNumber());
		}
		return customerRepository.save(customer);
	}
	
	public void deleteCustomerById(Long customerId) {
		if (!customerRepository.existsById(customerId)) {
			throw new InvalidOperationException("Error - no existe un cliente con ese ID!");
		}
		customerRepository.deleteById(customerId);
	}
	
	// Método para conversión Entidad -> DTO
    private CustomerDTO convertToDTO(Customer customer) {
    		return CustomerDTO.builder()
    				.firstName(customer.getFirstName())
    				.lastName(customer.getLastName())
    				.dni(customer.getDni())
    				.email(customer.getEmail())
    				.address(customer.getAddress())
    				.build();
    }	
}