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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coltraneinvoices.dto.CustomerDTO;
import com.coltraneinvoices.exception.InvalidOperationException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Clientes", description = "API Endpoints para gestión de clientes")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	// Métodos planos ya que manejamos Excepciones de forma global:
    @GetMapping("/{id}")
    @Operation(summary = "Obtener cliente por ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Cliente localizado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "404", description = "Cliente no encontrado")
		})
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
	
    @GetMapping("/search")
    @Operation(summary = "Buscar clientes según múltiples criterios", 
               description = "Permite buscar por DNI, email, teléfono, nombre o apellido. Exige, al menos, un parámetro.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente(s) encontrado(s)"),
        @ApiResponse(responseCode = "404", description = "No se encontró ningún cliente"),
        @ApiResponse(responseCode = "400", description = "Debe proporcionar al menos un parámetro")
    })
    public ResponseEntity<?> search(
        @RequestParam(required = false) Long dni,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) Long phoneNumber,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName
    ) {
        if (dni != null) {
            return ResponseEntity.ok(customerService.searchByDni(dni));
        } else if (email != null) {
            return ResponseEntity.ok(customerService.searchByEmail(email));
        } else if (phoneNumber != null) {
            return ResponseEntity.ok(customerService.searchByPhoneNumber(phoneNumber));
        } else if (firstName != null) {
            return ResponseEntity.ok(customerService.searchByFirstName(firstName));
        } else if (lastName != null) {
            return ResponseEntity.ok(customerService.searchByLastName(lastName));
        }
        
        throw new InvalidOperationException("Debe proporcionar al menos un parámetro de búsqueda.");
    }
    
    @GetMapping
    @Operation(summary = "Obtener un listado de todos los clientes")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Listado de clientes generado"),
		@ApiResponse(responseCode = "404", description = "No se han encontrado clientes")
		})
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    @PostMapping
	@Operation(summary = "Crear un cliente", 
    description = "Crea un cliente con los datos proporcionados") 
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "404", description = "Cliente no encontrado")
		})
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO dto) {
        Customer createdCustomer = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    	@PutMapping("/{id}")
    	@Operation(summary = "Actualiza a un cliente existente con los datos proporcionados")
    	@ApiResponses(value = {
    			@ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente"),
    			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
    			@ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    			})
    	public Customer updateCustomerById(@PathVariable Long id, @RequestBody CustomerDTO dto) {
    		return customerService.updateCustomer(id, dto);
    	}
    
    @DeleteMapping("/{id}")
	@Operation(summary = "Elimina el cliente cuyo ID se proporcione")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente eliminado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
			@ApiResponse(responseCode = "404", description = "Cliente no encontrado")
			})
    	public void deleteCustomerById(@PathVariable Long id) {
    		customerService.deleteCustomerById(id);
    }
    
}