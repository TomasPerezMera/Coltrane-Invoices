package com.coltraneinvoices.customer;

import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Schema(name = "Cliente", description = "Modelo de Cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Schema(name = "ID del cliente", example = "1")
	    @Column(name = "customer_id")
	    private Long customerId;
	    
	    
	    @Schema(name = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "dni", nullable = false, unique = true, length = 10)
	    private Long dni;
	    
	    @Schema(name = "Nombre del cliente", example = "Juan Carlos", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "first_name", nullable = false, length = 50)
	    private String firstName;
	    
	    
	    @Schema(name = "Apellido del cliente", example = "Gomez", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "last_name", nullable = false, length = 80)
	    private String lastName;
	    
	    
	    @Schema(name = "Email del cliente", example = "jcgomez123@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "email", nullable = false, length = 100)
	    private String email;
	    

	    @Schema(name = "Teléfono del cliente", example = "01145542023", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "phone_number", length = 20, nullable = false)
	    @Builder.Default
	    private Long phoneNumber = 0L;
	    
	    
	    @Schema(name = "Dirección del cliente", example = "Calle Ficticia, 45", requiredMode = Schema.RequiredMode.REQUIRED)
	    @Column(name = "address", length = 255)
	    private String address;
	    
	    
	    @Schema(name = "Fecha de creación del cliente", example = "2026-02-15 20:49:24.687995")
	    @Column(name = "created_at", nullable = false, updatable = false)
	    private OffsetDateTime createdAt;
	    
	}