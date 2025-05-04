package com.coderhouse.Coltrane_Invoices.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;


@Data
@Entity
@Table(name = "clients")
public class Client {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "name", nullable = false)
	private String name;
	
    @Column(name = "surname", nullable = false)
	private String surname;
	
    @Column(name = "dni", nullable = false, unique = true)
	private int dni;
	
    @Column(name = "email", nullable = false)
	private String email;
	
    @Column(name = "address", nullable = false)
	private String address;
	
    @CreationTimestamp
    @Column(name = "created_at", nullable = true, updatable = false)
    private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Sale> sales = new ArrayList<>();	
	
	public Client() {
		super();
	}


	public Client(String name, String surname, int dni, String email, String address,
			LocalDateTime createdAt) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
	}
}
