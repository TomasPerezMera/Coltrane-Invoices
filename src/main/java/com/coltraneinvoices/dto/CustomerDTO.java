package com.coltraneinvoices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para información del cliente")
public class CustomerDTO {

	// Read-Only para prevenir que Swagger indique al usuario ingresar ID.
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Long customerId;
	
    @NotNull(message = "El DNI es requerido!")
    @Positive(message = "Error - el DNI no puede ser negativo.")
    private Long dni;
    
    @NotNull(message = "El Nombre es requerido!")
    private String firstName;
    
    @NotNull(message = "El Apellido es requerido!")
    private String lastName;
    
    @NotNull(message = "El Email es requerido!")
    private String email;
    
    @NotNull(message = "La dirección es requerida!")
    private String address;
    
    // Número de teléfono es opcional.
    private Long phoneNumber;
    
}