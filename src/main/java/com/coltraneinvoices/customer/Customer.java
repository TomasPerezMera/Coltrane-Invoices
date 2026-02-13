package com.coltraneinvoices.customer;

import java.time.OffsetDateTime;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "customer_id")
	    private Long customerId;
	    
	    
	    @Column(name = "dni", nullable = false, unique = true, length = 10)
	    private Long dni;
	    
	    
	    @Column(name = "first_name", nullable = false, length = 50)
	    private String firstName;
	    
	    
	    @Column(name = "last_name", nullable = false, length = 80)
	    private String lastName;
	    
	    
	    @Column(name = "email", nullable = false, length = 100)
	    private String email;
	    

	    @Column(name = "phone_number", length = 20)
	    private Long phoneNumber;
	    
	    
	    @Column(name = "address", length = 255)
	    private String address;
	    
	    
	    @Column(name = "created_at", nullable = false, updatable = false)
	    private OffsetDateTime createdAt;
	    
	}